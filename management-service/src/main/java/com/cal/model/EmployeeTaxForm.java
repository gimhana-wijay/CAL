package com.cal.model;

public class EmployeeTaxForm {

    private int id;
    private double etf_fee;
    private double  epf_fee;
    private double tax_fee;
    private double sports_fee;
    private double stamp_fee;

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

    public double getEpf_fee() {
        return epf_fee;
    }

    public void setEpf_fee(double epf_fee) {
        this.epf_fee = epf_fee;
    }

    public double getTax_fee() {
        return tax_fee;
    }

    public void setTax_fee(double tax_fee) {
        this.tax_fee = tax_fee;
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
}
