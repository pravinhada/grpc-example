package com.example.grpc.service;

import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GreetingServiceOuterClass;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(com.example.grpc.GreetingServiceOuterClass.HelloRequest request,
                         io.grpc.stub.StreamObserver<com.example.grpc.GreetingServiceOuterClass.HelloResponse> responseObserver) {
        System.out.println(request);

        GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse
                .newBuilder()
                .setGreeting("Hello There, " + request.getName())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
