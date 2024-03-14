package com.cal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class EmployeeFinance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double salary;
	private String tax_enabled;
	private String etf_enabled;
	private String epf_enabled;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_tax_id", referencedColumnName = "id")
	private EmployeeTax employeeTax;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getTax_enabled() {
		return tax_enabled;
	}

	public void setTax_enabled(String tax_enabled) {
		this.tax_enabled = tax_enabled;
	}

	public String getEtf_enabled() {
		return etf_enabled;
	}

	public void setEtf_enabled(String etf_enabled) {
		this.etf_enabled = etf_enabled;
	}

	public String getEpf_enabled() {
		return epf_enabled;
	}

	public void setEpf_enabled(String epf_enabled) {
		this.epf_enabled = epf_enabled;
	}

	public EmployeeTax getEmployeeTax() {
		return employeeTax;
	}

	public void setEmployeeTax(EmployeeTax employeeTax) {
		this.employeeTax = employeeTax;
	}

}
