package com.training.assignment.restTemplate.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.training.assignment.restTemplate.demo.model.DataHandler;
import com.training.assignment.restTemplate.demo.model.Employee;

@RestController
public class DataController {

  @Autowired
  DataHandler dataHandler;

  @PostMapping("/employee")
  @ResponseBody
  public void postEmployee(@RequestBody Employee teleData) {
    dataHandler.postEmployee(teleData);


  }

  @GetMapping("/employee/{id}")
  @ResponseBody
  public String getEmployee(@PathVariable("id") int employeeId) {
    return dataHandler.getEmployee(employeeId);

  }

}
