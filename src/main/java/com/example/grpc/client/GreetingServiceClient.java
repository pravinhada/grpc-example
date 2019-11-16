package com.example.grpc.client;

import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GreetingServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class GreetingServiceClient {

    private GreetingServiceGrpc.GreetingServiceBlockingStub greetingServiceBlockingStub;

    @PostConstruct
    private void init() {
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:6565").usePlaintext().build();
        greetingServiceBlockingStub = GreetingServiceGrpc.newBlockingStub(channel);
    }

    public String greet(String name) {
        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest.newBuilder().setName(name).build();
        GreetingServiceOuterClass.HelloResponse response = greetingServiceBlockingStub.greeting(request);
        return response.getGreeting();
    }
}
