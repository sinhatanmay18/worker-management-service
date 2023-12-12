package com.ibuc.bookmyservice.workermanagementservice.controller;

import com.ibuc.bookmyservice.workermanagementservice.model.WorkerRequest;
import com.ibuc.bookmyservice.workermanagementservice.model.Worker;
import com.ibuc.bookmyservice.workermanagementservice.service.WorkerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/worker-management/worker")
@Slf4j
public class WorkerController {
    @Autowired
    private WorkerService workerService;
    @PostMapping("/saveWorker")
    public Worker saveWorker(@RequestBody Worker worker) throws Exception {
        log.info("Worker saved inside worker service");
        return workerService.saveWorker(worker);
    }

    @GetMapping("/{id}")
    public Worker findWorkerById(@PathVariable("id") Long workerId) throws Exception {
        log.info("inside worker service");
        return workerService.findWorkerById(workerId);
    }

    @PostMapping("/fetchByCategory")
    public ResponseEntity<List<Worker>> fetchWorkerByCategory(@RequestBody WorkerRequest workerRequest){
        return ResponseEntity.ok(this.workerService.findNearbyWorkers(workerRequest));
    }
}
