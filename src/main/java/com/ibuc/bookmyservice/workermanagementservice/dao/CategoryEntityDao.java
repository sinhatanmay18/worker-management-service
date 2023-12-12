package com.ibuc.bookmyservice.workermanagementservice.dao;

import com.ibuc.bookmyservice.workermanagementservice.WMConstants;
import com.ibuc.bookmyservice.workermanagementservice.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class CategoryEntityDao {
    @Autowired
    private RestTemplate restTemplate;

    private final String ENTITY_URI = "http://Entity-Service";

    public List<Category> findAllCategories() throws Exception {
        String url = ENTITY_URI + WMConstants.URI_FETCH_CATEGORIES;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<List<Category>> response = restTemplate.exchange(url, HttpMethod.GET,entity , new ParameterizedTypeReference<>() {});

        if (!response.getStatusCode().is2xxSuccessful()){
            throw new Exception("Unable to fetch data from entity service");
        }

        return response.getBody();
    }

    public List<Category> saveAllCategories(List<Category> categories) throws Exception {
        String url = ENTITY_URI + WMConstants.URI_SAVE_CATEGORIES;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<Category>> request = new HttpEntity<>(categories, headers);

        ResponseEntity<List<Category>> response = restTemplate.exchange(url, HttpMethod.POST, request, new ParameterizedTypeReference<>() {});

        if (!response.getStatusCode().is2xxSuccessful()){
            throw new Exception("Unable to fetch data from entity service");
        }

        return response.getBody();
    }

    public Category findCategoryById(Long id) throws Exception {
        String url = ENTITY_URI + WMConstants.URI_FETCH_CATEGORY_BY_ID;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        URI uri = UriComponentsBuilder.fromHttpUrl(url)
                .path("/" + id)
                .build()
                .toUri();

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<Category> response = restTemplate.exchange(uri, HttpMethod.GET,entity , new ParameterizedTypeReference<>() {});

        if (!response.getStatusCode().is2xxSuccessful()){
            throw new Exception("Unable to fetch data from entity service");
        }

        return response.getBody();
    }
}
