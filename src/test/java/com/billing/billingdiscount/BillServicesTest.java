package com.billing.billingdiscount;

import com.billing.billingdiscount.entity.BillRequest;
import com.billing.billingdiscount.entity.Client;
import com.billing.billingdiscount.service.BillService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BillServicesTest {

    private BillService billService;
    private BillRequest billRequest;

    @Before
    public void setUp() {
        billService = new BillService();
        billRequest =new BillRequest();
        billRequest.setItems(DataInitializer.getMixedItems());
    }

    @Test
    public void testDiscountForLoyaltyClient() {
        Client client = DataInitializer.getLoyaltyClient();
        billRequest.setClient(client);
        Assert.assertEquals(925.00, billService.calculateNetPayable(billRequest));
    }

    @Test
    public void testNODiscountForNonLoyaltyClient() {
        Client client = DataInitializer.getNonLoyaltyClient();
        billRequest.setClient(client);
        Assert.assertEquals(950.00, billService.calculateNetPayable(billRequest));
    }

    @Test
    public void testDiscountForAffiliateClient() {
        Client client = DataInitializer.getAffiliateClient();
        billRequest.setClient(client);
        Assert.assertEquals(855.00, billService.calculateNetPayable(billRequest));
    }

    @Test
    public void testDiscountForEmployeeClient() {
        Client client = DataInitializer.getEmployeeClient();
        billRequest.setClient(client);
        Assert.assertEquals(565, billService.calculateNetPayable(billRequest));
    }
}
