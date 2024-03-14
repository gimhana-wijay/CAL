package com.cal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cal.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeTaxRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e.id, e.name, e.nic, e.address, e.email, e.mobile, ef.salary, " +
    	   "et.employee_epf_fee, et.tax_fee_per_month, et.employee_home_salary " +
           "FROM Employee e " +
           "JOIN e.employeeFinance ef " +
           "JOIN ef.employeeTax et " +
           "WHERE et.tax_fee_per_year = (SELECT MIN(et.tax_fee_per_year) FROM EmployeeTax et)")
    
    List<Object[]> findEmployeesWithMinTaxFeePerYear();
}
