package com.shoppingcart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageTest {

    @Test
    public void testMessage(){
        Message message = new Message();
        String res = message.getMessage("Anna");
        Assertions.assertEquals("Hello Anna !", res);
    }
}
