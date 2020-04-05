package com.nan.grpccookbook.server;

import io.grpc.stub.StreamObserver;

import com.nan.grpccookbook.Ingredient;
import com.nan.grpccookbook.RecipeRequest;
import com.nan.grpccookbook.RecipeResponse;
import com.nan.grpccookbook.RecipeServiceGrpc.RecipeServiceImplBase;

public class RecipeServiceImpl extends RecipeServiceImplBase {

    @Override
    public void recipe(
      RecipeRequest request, StreamObserver<RecipeResponse> responseObserver) {
        System.out.println("Request received from client:\n" + request);

        RecipeResponse response = RecipeResponse.newBuilder()
        .setTitle("Steak frites")
        .setDescription("French dish with steak and french fries")
        .addIngredients(Ingredient.newBuilder().setName("French fries").setQuantity("150g").build())
        .addIngredients(Ingredient.newBuilder().setName("Steak").setQuantity("1kg").build())
        .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}