package com.billing.billingdiscount;

import com.billing.billingdiscount.entity.Item;
import org.junit.Assert;
import org.junit.Test;

public class ItemTest {
    @Test
    public void testGroceryItem() {
        Item item = DataInitializer.getGroceryItem(4);
        Assert.assertEquals(400, item.getDiscountedPrice(5),0);
    }

    @Test
    public void testNonGroceryItem() {
        Item item = DataInitializer.getNonGroceryItem(4);
        Assert.assertEquals(570, item.getDiscountedPrice(5),0);
    }

}
