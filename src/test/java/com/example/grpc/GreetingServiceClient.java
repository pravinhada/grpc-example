package com.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingServiceClient {

    public static void main(String[] args) {
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8090").usePlaintext(true).build();
        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest.newBuilder().setName("Prabin").build();
        GreetingServiceOuterClass.HelloResponse response = stub.greeting(request);
        System.out.println(response);
        channel.shutdown();
    }
}
