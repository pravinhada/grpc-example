package com.example.grpc.service;

import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GreetingServiceOuterClass;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
@Slf4j
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(com.example.grpc.GreetingServiceOuterClass.HelloRequest request,
                         io.grpc.stub.StreamObserver<com.example.grpc.GreetingServiceOuterClass.HelloResponse> responseObserver) {
        log.info("Called greeting() grpc method with request: " + request);

        GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse
                .newBuilder()
                .setGreeting("Welcome " + request.getName() + "!")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void greetManyTimes(GreetingServiceOuterClass.GreetManyTimeRequest request,
                               StreamObserver<GreetingServiceOuterClass.GreetManyTimeResponse> responseObserver) {
        log.info("Called greetManyTimes() grpc method with request: " + request);

        String name = request.getHelloRequest().getName();
        for (int i = 0; i < 5; i++) {
            GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse.newBuilder()
                    .setGreeting("Welcome: " + name + " times: " + i).build();
            GreetingServiceOuterClass.GreetManyTimeResponse greetResponse = GreetingServiceOuterClass.GreetManyTimeResponse.newBuilder()
                    .setHelloResponse(response)
                    .build();
            responseObserver.onNext(greetResponse);
        }
        responseObserver.onCompleted();
    }
}
