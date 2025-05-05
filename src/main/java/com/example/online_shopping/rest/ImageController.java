package com.example.online_shopping.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@RestController
public class ImageController {

    private final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .followRedirects(HttpClient.Redirect.ALWAYS)
            .build();

    @GetMapping("/image/{fileId}")
    public void getProfileImage(@PathVariable String fileId, HttpServletResponse response) {
        String driveUrl = "https://drive.google.com/uc?id=" + fileId + "&export=download";
        
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(driveUrl))
                    .GET()
                    .build();

            HttpResponse<InputStream> httpResponse = httpClient.send(
                    request, 
                    HttpResponse.BodyHandlers.ofInputStream()
            );

            if (httpResponse.statusCode() == 200) {
                httpResponse.headers().firstValue("Content-Type")
                        .ifPresent(ct -> response.setContentType(ct));
                
                try (InputStream inputStream = httpResponse.body()) {
                    StreamUtils.copy(inputStream, response.getOutputStream());
                }
            } else {
                response.setStatus(httpResponse.statusCode());
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            // Consider adding logging here
        }
    }
}