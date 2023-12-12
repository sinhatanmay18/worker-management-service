package com.ibuc.bookmyservice.workermanagementservice.dao;

import com.ibuc.bookmyservice.workermanagementservice.WMConstants;
import com.ibuc.bookmyservice.workermanagementservice.model.Worker;
import com.ibuc.bookmyservice.workermanagementservice.model.WorkerEntityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class WorkerEntityDao {
    @Autowired
    private RestTemplate restTemplate;

    private final String ENTITY_URI = "http://Entity-Service";

    public Worker saveWorker(Worker worker) throws Exception {
        String url = ENTITY_URI + WMConstants.URI_SAVE_WORKER;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Worker> request = new HttpEntity<>(worker, headers);

        ResponseEntity<Worker> response = restTemplate.exchange(url, HttpMethod.POST, request, new ParameterizedTypeReference<>() {});

        if (!response.getStatusCode().is2xxSuccessful()){
            throw new Exception("Unable to fetch data from entity service");
        }

        return response.getBody();
    }

    public Worker findWorkerById(Long id) throws Exception {
        String url = ENTITY_URI + WMConstants.URI_FETCH_WORKER;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        URI uri = UriComponentsBuilder.fromHttpUrl(url)
                .path("/" + id)
                .build()
                .toUri();

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<Worker> response = restTemplate.exchange(uri, HttpMethod.GET,entity , new ParameterizedTypeReference<>() {});

        if (!response.getStatusCode().is2xxSuccessful()){
            throw new Exception("Unable to fetch data from entity service");
        }

        return response.getBody();
    }

    public List<Worker> fetchByH3Index(WorkerEntityRequest workerEntityRequest) throws Exception {
        String url = ENTITY_URI + WMConstants.FIND_BY_H3_INDEX;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<WorkerEntityRequest> request = new HttpEntity<>(workerEntityRequest, headers);

        ResponseEntity<List<Worker>> response = restTemplate.exchange(url, HttpMethod.POST, request, new ParameterizedTypeReference<>() {});

        if (!response.getStatusCode().is2xxSuccessful()){
            throw new Exception("Unable to fetch data from entity service");
        }

        return response.getBody();
    }
}
