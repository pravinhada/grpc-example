package com.example.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringGrpcApplication {

    public static void main(String[] args) throws Exception {
        /*Server server = ServerBuilder.forPort(8090)
                .addService(new GreetingServiceImpl())
                .build();

        server.start();

        System.out.println("Server Started!");
        server.awaitTermination();*/
        SpringApplication.run(SpringGrpcApplication.class,args);
    }
}
