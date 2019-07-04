package com.billing.billingdiscount;

import com.billing.billingdiscount.controller.BillController;
import com.billing.billingdiscount.entity.Client;
import com.billing.billingdiscount.entity.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(BillController.class)
public class BillControllerTest {


    @Autowired
    private MockMvc mvc;

    @Test
    public void testRestWorking() throws Exception {
        Client client = DataInitializer.getLoyaltyClient();
        List<Item> items = DataInitializer.getMixedItems();
        MvcResult mvcResult = mvc.perform(get("/bill/calculateDiscount")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String billResponse = mvcResult.getResponse().getContentAsString();
        System.out.println("--------------->>>>>>>>>  " + billResponse);

    }

}
