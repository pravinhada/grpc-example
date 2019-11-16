package com.example.grpc;

import com.example.grpc.service.GreetingServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;

public class App {

    public static void main(String[] args) throws Exception {
        /*Server server = ServerBuilder.forPort(8090)
                .addService(new GreetingServiceImpl())
                .build();

        server.start();

        System.out.println("Server Started!");
        server.awaitTermination();*/
        SpringApplication.run()
    }
}
