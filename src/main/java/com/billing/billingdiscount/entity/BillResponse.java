package com.billing.billingdiscount.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillResponse {

    private Client client;
    private double totalPrice;
    private double discount;
    private double discountBasedOnTotalAmount;
    private double netPayment;

}
