package com.billing.billingdiscount.entity;

public enum ClientType {

    AFFILIATE(10),EMPLOYEE(30),CUSTOMER(5);

    private double discountPercentage;

    ClientType(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

}
