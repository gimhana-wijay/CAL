package com.cal.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cal.constant.CommonConstant;
import com.cal.entity.Employee;
import com.cal.entity.EmployeeFinance;
import com.cal.entity.EmployeeTax;
import com.cal.model.EmployeeForm;
import com.cal.model.EmployeeReport;
import com.cal.repository.EmployeeRepository;
import com.cal.repository.EmployeeTaxRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeTaxRepository employeeTaxRepository;
	
    public Employee saveEmployeeProcess(EmployeeForm form) throws IOException {
    	System.out.println("################## saveEmployeeProcess : " + form);
    	Employee employeeResponse = new Employee();
        
        try {
        	Employee employee = dataInitializer(form);
        	
        	employeeResponse = employeeRepository.save(employee);
        	System.out.println("################## pass : " + employeeResponse.getId());
        	return employeeResponse;
		} catch (Exception e) {
			System.out.println("################## err : " + e);
    }
        return null;
    }

	private Employee dataInitializer(EmployeeForm form) {
		Employee employee = new Employee();
		employee.setName(form.getName());
		employee.setNic(form.getNic());
		employee.setAddress(form.getAddress());
		employee.setEmail(form.getEmail());
		employee.setMobile(form.getMobile());
		
		EmployeeFinance employeeFinance = new EmployeeFinance();
		employeeFinance.setEpf_enabled(CommonConstant.ENABLED);
		employeeFinance.setEtf_enabled(CommonConstant.ENABLED);
		employeeFinance.setTax_enabled(CommonConstant.DISABLED);
		employeeFinance.setSalary(form.getEmployeeFinanceForm().getSalary());

		if ((employeeFinance.getSalary() * 12) >= 1200000.00) {
			employeeFinance.setTax_enabled(CommonConstant.ENABLED);
			System.out.println("employeeFinance.getTax_enabled() ENABLED");
		}
		
		EmployeeTax employeeTax= new EmployeeTax();
		double epf_amount_employer = employeeFinance.getSalary() * 12/100;
		double epf_amount_employee = employeeFinance.getSalary() * 8/100;
		double epf_full_amount = epf_amount_employer + epf_amount_employee;
		double etf_amount = employeeFinance.getSalary() * 3/100;
		double sports_fee = employeeFinance.getSalary() * 0.5/100;
		double stamp_fee = 25.00;
		double company_total_cost = employeeFinance.getSalary() + epf_amount_employer + etf_amount + sports_fee + stamp_fee;
		
		employeeTax.setEmployer_epf_fee(epf_amount_employer);
		employeeTax.setEmployee_epf_fee(epf_amount_employee);
		employeeTax.setFull_epf_fee(epf_full_amount);
		employeeTax.setEtf_fee(etf_amount);
		employeeTax.setCompany_total_cost(company_total_cost);
		
		double one_year_tax = 00.00;
		double one_month_tax = 00.00;
		if (employeeFinance.getTax_enabled().equalsIgnoreCase(CommonConstant.ENABLED)) {
			double one_year_salary = employeeFinance.getSalary() * 12;
			double tax_range = (one_year_salary - 1200000.00) / 500000.00;
			
			if (tax_range  < 1) {
				one_year_tax = one_year_salary * 6/100;
				one_month_tax= one_year_tax / 12;
			}else if (tax_range  < 2) {
				one_year_tax = one_year_salary * 12/100;
				one_month_tax= one_year_tax / 12;
			}else if (tax_range  < 3) {
				one_year_tax = one_year_salary* 18/100;
				one_month_tax= one_year_tax / 12;
			}else if (tax_range  < 4) {
				one_year_tax = one_year_salary * 24/100;
				one_month_tax= one_year_tax / 12;
			}else if (tax_range  < 5) {
				one_year_tax = one_year_salary * 30/100;
				one_month_tax= one_year_tax / 12;
			}else if (tax_range  >= 5) {
				one_year_tax = one_year_salary * 36/100;
				one_month_tax= one_year_tax / 12;
			}
		}
		
		employeeTax.setTax_fee_per_year(one_year_tax);
		employeeTax.setTax_fee_per_month(one_month_tax);
		employeeTax.setSports_fee(sports_fee);
		employeeTax.setStamp_fee(stamp_fee);
		
		double employee_home_salary = employeeFinance.getSalary()- (epf_amount_employee + stamp_fee + one_month_tax);
		employeeTax.setEmployee_home_salary(employee_home_salary);

		employeeFinance.setEmployeeTax(employeeTax);
		employee.setEmployeeFinance(employeeFinance);
		return employee;
	}
	
    public List<Employee> findEmployeesWithMinTaxFeePerYear() throws IOException {
    	System.out.println("################## findEmployeesWithMinTaxFeePerYear : ");
    	List<Object[]> queryResult = new ArrayList<Object[]>();
    	List<Employee> employees = new ArrayList<>();
        try {        	
        	queryResult = employeeTaxRepository.findEmployeesWithMinTaxFeePerYear();
        	for (Object[] row : queryResult) {
                Employee employee = new Employee();
                EmployeeFinance finance = new EmployeeFinance();
                EmployeeTax employeeTax = new EmployeeTax();
                employee.setId((Integer) row[0]);
                employee.setName((String) row[1]);
                employee.setNic((String) row[2]);
                employee.setAddress((String) row[3]);
                employee.setEmail((String) row[4]);
                employee.setMobile((String) row[5]);
                finance.setSalary((double) row[6]);
                employeeTax.setEmployee_epf_fee((double) row[7]);
                employeeTax.setTax_fee_per_month((double) row[8]);
                employeeTax.setEmployee_home_salary((double) row[9]);
                finance.setEmployeeTax(employeeTax);
                employee.setEmployeeFinance(finance);
                employees.add(employee);
            }
        	System.out.println("################## pass : ");
        	return employees;
		} catch (Exception e) {
			System.out.println("################## err : " + e);
    }
        return null;
    }
    
    public List<EmployeeReport> getAllEmployeesSalaryDetails() throws IOException {
    	System.out.println("################## getAllEmployeesSalaryDetails : ");
    	List<Employee> employees = new ArrayList<>();
    	List<EmployeeReport> reports = new ArrayList<>();
        try {        	
        	employees = employeeRepository.findAll();
        	System.out.println("################## queryResult size : " + employees.size());
        	for (Employee employee : employees) {
        		EmployeeReport employeeReport = new EmployeeReport();
        		employeeReport.setId(employee.getId());
        		employeeReport.setEmployee_name((employee.getName()));
        		employeeReport.setEmployee_salary((employee.getEmployeeFinance().getSalary()));
        		employeeReport.setEmployee_home_salary(employee.getEmployeeFinance().getEmployeeTax().getEmployee_home_salary());
        		employeeReport.setCompany_total_cost((employee.getEmployeeFinance().getEmployeeTax().getCompany_total_cost()));
                reports.add(employeeReport);
            }
        	System.out.println("################## pass : ");
        	return reports;
		} catch (Exception e) {
			System.out.println("################## err : " + e);
    }
        return null;
    }
}
