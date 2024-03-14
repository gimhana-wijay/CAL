package com.cal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cal.entity.Employee;
import com.cal.model.EmployeeForm;
import com.cal.model.EmployeeReport;
import com.cal.service.EmployeeService;

@RestController
@RequestMapping("/cal-api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/test")
    public String testMethod(){
        return "connected cal-api-gateway!!";
    }

    @PostMapping("/employee-setup")
    public ResponseEntity<Employee> saveEmployeeProcess(@RequestBody EmployeeForm form) throws Exception {
    	Employee employee = (Employee) employeeService.saveEmployeeProcess(form);
        if (employee.getId() != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(employee, HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/employee-mintax")
    public ResponseEntity<List<Employee>> findEmployeesWithMinTaxFeePerYear() throws Exception {
    	List<Employee> employee = employeeService.findEmployeesWithMinTaxFeePerYear();
        if (employee.size() != 0) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(employee, HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/all-employee-salary")
    public ResponseEntity<List<EmployeeReport>> getAllEmployeesSalaryDetails() throws Exception {
    	List<EmployeeReport> employeeReports = employeeService.getAllEmployeesSalaryDetails();
        if (employeeReports.size() != 0) {
            return new ResponseEntity<>(employeeReports, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(employeeReports, HttpStatus.BAD_REQUEST);
        }
    }
    
}
