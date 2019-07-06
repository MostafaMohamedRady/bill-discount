package com.billing.billingdiscount.utils;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class DiscountConfig {

    public static int LOYALTY_YEARS=2;

    public static int NORMAL_DISCOUNT=5;


    public static int calculatePeriod(Date registrationDate) {
            if (registrationDate != null) {
                LocalDate old=registrationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate now=new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                return Period.between(old, now).getYears();
            } else {
                return 0;
            }
        }

}
