package com.training.assignment.restTemplate.demo.controller.service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.training.assignment.restTemplate.demo.model.Employee;

@Service
public class EmployeeHandler {

  RestTemplate restTemplate;

  @Value("${website.url}")
  String url;
  @Value("${website.employee}")
  String employeeExtension;


  @Autowired
  private EmployeeHandler(@Lazy RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();

  }

  public String getEmployee(int employeeId) {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity = new HttpEntity<>(headers);
    return this.restTemplate
        .exchange(url + employeeExtension + employeeId, HttpMethod.GET, entity, String.class)
        .getBody();
  }

  public void postEmployee(Employee teleData) {
    this.restTemplate.postForObject(url + employeeExtension, teleData, Employee.class);
  }
}
