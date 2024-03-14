package com.cal.model;

public class EmployeeFinanceForm {
	private int id;
	private double salary;
	private String tax_enabled;
	private String etf_enabled;
	private String epf_enabled;
	private EmployeeTaxForm employeeTaxForm;

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

	public String isTax_enabled() {
		return tax_enabled;
	}

	public void setTax_enabled(String tax_enabled) {
		this.tax_enabled = tax_enabled;
	}

	public String isEtf_enabled() {
		return etf_enabled;
	}

	public void setEtf_enabled(String etf_enabled) {
		this.etf_enabled = etf_enabled;
	}

	public String isEpf_enabled() {
		return epf_enabled;
	}

	public void setEpf_enabled(String epf_enabled) {
		this.epf_enabled = epf_enabled;
	}

	public EmployeeTaxForm getEmployeeTaxForm() {
		return employeeTaxForm;
	}

	public void setEmployeeTaxForm(EmployeeTaxForm employeeTaxForm) {
		this.employeeTaxForm = employeeTaxForm;
	}

}
