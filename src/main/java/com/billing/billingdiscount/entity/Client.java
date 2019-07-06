package com.billing.billingdiscount.entity;

import com.billing.billingdiscount.utils.DiscountConfig;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.beans.Transient;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private int id;
    private String name;
    private Date registrationDate;
    private ClientType clientType;

    /**
     * check if this client available for loyal discount (more than two years)
     * @returnn
     */
    @JsonIgnore
    public boolean isLoyalClient() {
        return DiscountConfig.calculatePeriod(registrationDate)>=DiscountConfig.LOYALTY_YEARS && clientType==ClientType.CUSTOMER;
    }


}
