package com.billing.billingdiscount;

import com.billing.billingdiscount.controller.BillController;
import com.billing.billingdiscount.entity.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(BillController.class)
public class ClientTest {

    @Test
    public void testLoyaltyClient() {
        Client client = DataInitializer.getLoyaltyClient();
        Assert.assertTrue(client.isLoyalClient());
    }

    @Test
    public void testNonLoyaltyClient() {
        Client client = DataInitializer.getNonLoyaltyClient();
        Assert.assertTrue(client.isLoyalClient());
    }

}
