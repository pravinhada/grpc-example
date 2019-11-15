package com.example.grpc.client;

import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GreetingServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {

    public static void main(String[] args) throws Exception {
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080").usePlaintext(true).build();
        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest.newBuilder().setName("Prabin").build();
        GreetingServiceOuterClass.HelloResponse response = stub.greeting(request);
        System.out.println(response);
        channel.shutdown();
    }
}
