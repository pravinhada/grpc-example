package com.example.grpc;

import com.example.grpc.client.GreetingServiceClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GreetingServiceTest {

    @Autowired
    private GreetingServiceClient greetingServiceClient;

    @Test
    public void testGreetingService() {
        Assert.assertEquals(greetingServiceClient.greet("Prabin"), "Welcome Prabin!");
        Assert.assertEquals(greetingServiceClient.greet("XYZ"), "Welcome XYZ!");
    }

    @Test
    public void testGreetManyTimeService() {
        Assert.assertEquals(greetingServiceClient.greetManyTimes("Alex").size(), 5);
    }
}
