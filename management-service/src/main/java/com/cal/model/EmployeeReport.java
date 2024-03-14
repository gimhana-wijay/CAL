package com.cal.model;

public class EmployeeReport {
	private Integer id;
	private String employee_name;
	private double employee_salary;
	private double employee_home_salary;
	private double company_total_cost;

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public double getEmployee_salary() {
		return employee_salary;
	}

	public void setEmployee_salary(double employee_salary) {
		this.employee_salary = employee_salary;
	}

	public double getEmployee_home_salary() {
		return employee_home_salary;
	}

	public void setEmployee_home_salary(double employee_home_salary) {
		this.employee_home_salary = employee_home_salary;
	}

	public double getCompany_total_cost() {
		return company_total_cost;
	}

	public void setCompany_total_cost(double company_total_cost) {
		this.company_total_cost = company_total_cost;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
