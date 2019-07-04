package com.billing.billingdiscount.service;

import com.billing.billingdiscount.entity.*;
import com.billing.billingdiscount.utils.DiscountConfig;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    public BillResponse calculateNetPayable(BillRequest bill) {

        double totalDiscountedPrice = 0;//price before 5$ each 100$
        double totalBillPrice=0;
        double discountPercentage = getDiscountPercentage(bill.getClient());
        for(Item item:bill.getItems()) {
            totalDiscountedPrice +=  item.getDiscountedPrice(discountPercentage);
            totalBillPrice += item.getTotalCost();
        }

        double discount = totalBillPrice-totalDiscountedPrice;
        double discountBasedOnTotalAmount=getDiscountBasedOnTotalAmount(totalDiscountedPrice);
        double newPayment=Math.round(totalDiscountedPrice - discountBasedOnTotalAmount);
        return new BillResponse(bill.getClient(),discount,totalBillPrice,newPayment,discountBasedOnTotalAmount);
    }


    private double getDiscountPercentage(Client client) {
        ClientType clientType = client.getClientType();
        if(clientType == ClientType.AFFILIATE || clientType == ClientType.EMPLOYEE || client.isLoyalClient()) {
            return clientType.getDiscountPercentage();
        }
        return 0;
    }

    private double getDiscountBasedOnTotalAmount(double totalDiscountedPrice) {
        return Math.floor(totalDiscountedPrice / 100) * DiscountConfig.NORMAL_DISCOUNT;
    }
}