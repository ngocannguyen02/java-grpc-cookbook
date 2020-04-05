package com.nan.grpccookbook.client;

import com.nan.grpccookbook.RecipeRequest;
import com.nan.grpccookbook.RecipeResponse;
import com.nan.grpccookbook.RecipeServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcRecipeClient {

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
            .usePlaintext()
            .build();

        RecipeServiceGrpc.RecipeServiceBlockingStub stub 
          = RecipeServiceGrpc.newBlockingStub(channel);

        RecipeResponse helloResponse = stub.recipe(RecipeRequest.newBuilder()
            .setTitle("Steak frites")
            .build());

        System.out.println("Response received from server:\n" + helloResponse);

        channel.shutdown();
    }

}