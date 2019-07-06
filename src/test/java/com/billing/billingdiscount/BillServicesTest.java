package com.billing.billingdiscount;

import com.billing.billingdiscount.entity.BillRequest;
import com.billing.billingdiscount.entity.Client;
import com.billing.billingdiscount.service.BillService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

public class BillServicesTest {


    private BillService billService;
    private BillRequest billRequest;

    @Before
    public void setUp() {
        billService=new BillService();
        billRequest =new BillRequest();
        billRequest.setItems(DataInitializer.getMixedItems());
    }

    @Test
    public void testDiscountForLoyaltyClient() {
        Client client = DataInitializer.getLoyaltyClient();
        billRequest.setClient(client);
        Assert.assertEquals(925.00, billService.calculateNetPayable(billRequest).getNetPayment(),0);
    }

    @Test
    public void testNoDiscountForNonLoyaltyClient() {
        Client client = DataInitializer.getNonLoyaltyClient();
        billRequest.setClient(client);
        Assert.assertEquals(950.00, billService.calculateNetPayable(billRequest).getNetPayment(),0);
    }

    @Test
    public void testDiscountForAffiliateClient() {
        Client client = DataInitializer.getAffiliateClient();
        billRequest.setClient(client);
        Assert.assertEquals(895.00, billService.calculateNetPayable(billRequest).getNetPayment(),0);
    }

    @Test
    public void testDiscountForEmployeeClient() {
        Client client = DataInitializer.getEmployeeClient();
        billRequest.setClient(client);
        Assert.assertEquals(780.00, billService.calculateNetPayable(billRequest).getNetPayment(),0);
    }
}
