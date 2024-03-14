package com.cal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeTax {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double etf_fee;
	private double full_epf_fee;
	private double employer_epf_fee;
	private double employee_epf_fee;
	private double tax_fee_per_year;
	private double tax_fee_per_month;
	private double sports_fee;
	private double stamp_fee;
	private double company_total_cost;
	private double employee_home_salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getEtf_fee() {
		return etf_fee;
	}
	public void setEtf_fee(double etf_fee) {
		this.etf_fee = etf_fee;
	}
	public double getFull_epf_fee() {
		return full_epf_fee;
	}
	public void setFull_epf_fee(double full_epf_fee) {
		this.full_epf_fee = full_epf_fee;
	}
	public double getEmployer_epf_fee() {
		return employer_epf_fee;
	}
	public void setEmployer_epf_fee(double employer_epf_fee) {
		this.employer_epf_fee = employer_epf_fee;
	}
	public double getEmployee_epf_fee() {
		return employee_epf_fee;
	}
	public void setEmployee_epf_fee(double employee_epf_fee) {
		this.employee_epf_fee = employee_epf_fee;
	}
	public double getTax_fee_per_year() {
		return tax_fee_per_year;
	}
	public void setTax_fee_per_year(double tax_fee_per_year) {
		this.tax_fee_per_year = tax_fee_per_year;
	}
	public double getTax_fee_per_month() {
		return tax_fee_per_month;
	}
	public void setTax_fee_per_month(double tax_fee_per_month) {
		this.tax_fee_per_month = tax_fee_per_month;
	}
	public double getSports_fee() {
		return sports_fee;
	}
	public void setSports_fee(double sports_fee) {
		this.sports_fee = sports_fee;
	}
	public double getStamp_fee() {
		return stamp_fee;
	}
	public void setStamp_fee(double stamp_fee) {
		this.stamp_fee = stamp_fee;
	}
	public double getCompany_total_cost() {
		return company_total_cost;
	}
	public void setCompany_total_cost(double company_total_cost) {
		this.company_total_cost = company_total_cost;
	}
	public double getEmployee_home_salary() {
		return employee_home_salary;
	}
	public void setEmployee_home_salary(double employee_home_salary) {
		this.employee_home_salary = employee_home_salary;
	}	
}
