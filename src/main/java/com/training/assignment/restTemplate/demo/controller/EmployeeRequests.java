package com.training.assignment.restTemplate.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.training.assignment.restTemplate.demo.controller.service.EmployeeHandler;
import com.training.assignment.restTemplate.demo.model.Employee;

@RestController
public class EmployeeRequests {

  @Autowired
  EmployeeHandler employeeHandler;

  @PostMapping("/employee")
  @ResponseBody
  public void postEmployee(@RequestBody Employee teleData) {
    employeeHandler.postEmployee(teleData);


  }

  @GetMapping("/employee/{id}")
  @ResponseBody
  public String getEmployee(@PathVariable("id") int employeeId) {
    return employeeHandler.getEmployee(employeeId);

  }

}
