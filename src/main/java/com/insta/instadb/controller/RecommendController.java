package com.insta.instadb.controller;

import com.insta.instadb.api.RecommendationApi;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class RecommendController implements RecommendationApi {
    @Override
    public void reCommend() {
        String url = "http://localhost:5005/recommendation/recommended-interests/" + "";

        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create JSON payload if needed
//        String jsonBody = "{\"key\":\"value\"}"; // Replace this with your JSON payload

        // Create a POST request
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .header("Content-Type", "application/json") // Set content type if sending JSON data
//                .POST(HttpRequest.BodyPublishers.ofString(jsonBody)) // Set the request body
//                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json") // Set Accept header if expecting JSON response
                .build();

        try {
            // Send the POST request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print the response status code and body
            System.out.println("Response Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
}
