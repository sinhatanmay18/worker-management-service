package com.ibuc.bookmyservice.workermanagementservice.service;

import com.ibuc.bookmyservice.workermanagementservice.WorkerServiceConstants;
import com.ibuc.bookmyservice.workermanagementservice.dao.WorkerEntityDao;
import com.ibuc.bookmyservice.workermanagementservice.model.TimeSlot;
import com.ibuc.bookmyservice.workermanagementservice.model.WorkerEntityRequest;
import com.ibuc.bookmyservice.workermanagementservice.model.WorkerRequest;
import com.ibuc.bookmyservice.workermanagementservice.model.Worker;
import com.uber.h3core.H3Core;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WorkerService {
    @Autowired
    private WorkerEntityDao workerEntityDao;

    @Autowired
    private H3Core h3Core;

    public Worker saveWorker(Worker worker) throws Exception {
        Worker newWorker = this.setWorkerAttributes(worker);
        return this.workerEntityDao.saveWorker(newWorker);
    }

    public Worker findWorkerById(Long workerId) throws Exception {
        return this.workerEntityDao.findWorkerById(workerId);
    }

    public List<TimeSlot> getTimeSlotByWorker(Long workerId) throws Exception {
        return this.workerEntityDao.findTimeSlotsByWorkerId(workerId);
    }

    private Worker setWorkerAttributes(Worker worker){
        return Worker.builder()
                .workerId(worker.getWorkerId())
                .workerName(worker.getWorkerName())
                .age(worker.getAge())
                .phoneNumber(worker.getPhoneNumber())
                .categoryId(worker.getCategoryId())
                .availabilityStatus(worker.isAvailabilityStatus())
                .h3Index(this.h3Core.geoToH3(worker.getWorkerLocation().getLatitude() , worker.getWorkerLocation().getLongitude() , 6))
                .build();
    }

    public List<Worker> findNearbyWorkers(WorkerRequest workerRequest) {
        Long userH3Index = this.h3Core.geoToH3(workerRequest.getLatitude(), workerRequest.getLongitude(), WorkerServiceConstants.RESOLUTION);
        List<Long> nearbyIndexes = this.h3Core.kRing(userH3Index, WorkerServiceConstants.DISTANCE);
        WorkerEntityRequest workerEntityRequest = WorkerEntityRequest.builder()
                .categoryId(workerRequest.getCategoryId())
                .h3Indexes(nearbyIndexes)
                .build();
        try{
            return this.workerEntityDao.fetchByH3Index(workerEntityRequest);
        } catch (Exception ex){
            return List.of();
        }
    }
}
