package com.training.assignment.restTemplate.demo.model;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataHandler {

  RestTemplate restTemplate;


  @Autowired
  private DataHandler(@Lazy RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();

  }

  public String getEmployee(int employeeId) {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity = new HttpEntity<>(headers);
    return this.restTemplate.exchange("http://localhost:8080/employee/" + employeeId,
        HttpMethod.GET, entity, String.class).getBody();
  }

  public void postEmployee(Employee teleData) {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity = new HttpEntity<>(headers);
    this.restTemplate.postForObject("http://localhost:8080/employee/", teleData, Employee.class);
  }
}
