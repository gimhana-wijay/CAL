package com.cal.model;

public class EmployeeForm {
	private int id;
	private String name;
	private String nic;
	private String address;
	private String email;
	private String mobile;
	private EmployeeFinanceForm employeeFinanceForm;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public EmployeeFinanceForm getEmployeeFinanceForm() {
		return employeeFinanceForm;
	}

	public void setEmployeeFinanceForm(EmployeeFinanceForm employeeFinanceForm) {
		this.employeeFinanceForm = employeeFinanceForm;
	}

}
