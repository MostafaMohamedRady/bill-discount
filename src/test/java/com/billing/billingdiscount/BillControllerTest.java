package com.billing.billingdiscount;

import com.billing.billingdiscount.controller.BillController;
import com.billing.billingdiscount.entity.BillRequest;
import com.billing.billingdiscount.entity.Client;
import com.billing.billingdiscount.entity.Item;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringRunner.class)
public class BillControllerTest {


    private MockMvc mvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setup(){
        mvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testRestWorking() throws Exception {
        Client client = DataInitializer.getLoyaltyClient();
        List<Item> items = DataInitializer.getMixedItems();
        BillRequest billRequest=new BillRequest(client,items);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/bill/calculateDiscount")
                .contentType(MediaType.APPLICATION_JSON).content(mapToJson(billRequest)))
                .andExpect(status().isOk()).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String billResponse = mvcResult.getResponse().getContentAsString();
        System.out.println("--------------->>>>>>>>>  " + billResponse);

    }

    private String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

}
