package com.ccx2.wordCounter2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

//@Component
//public class RealTranslator implements Translator{
//
//    private final String apiKey; // API key for the translation service
//    private final HttpClient httpClient;
//
//    @Autowired
//    public RealTranslator(@Value("${api.key}") String apiKey) {
//        this.apiKey = apiKey;
//        this.httpClient = HttpClient.newHttpClient();
//    }
//
//    @Override
//    public String translate(String word) {
//        if (word == null) {
//            throw new IllegalArgumentException("Input word cannot be null");
//        }
//
//        try {
//            URI uri = URI.create("https://api.example.com/translate?text=" + word + "&targetLang=en");
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(uri)
//                    .header("Authorization", "Bearer " + this.apiKey)
//                    .build();
//
//            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
//            if (response.statusCode() == 200) {
//                return response.body(); // Assuming the API returns the translated text directly
//            } else {
//                return "Error: Failed to translate due to " + response.statusCode();
//            }
//        } catch (Exception e) {
//            return "Error: " + e.getMessage();
//        }
//    }
//}

@Component
public class RealTranslator implements Translator {
    // This is a simple representation. In a real scenario, you would be calling an external API.

    @Override
    public String translate(String word) {
//       return word;

        if (word.equalsIgnoreCase("flor") || word.equalsIgnoreCase("blume") || word.equalsIgnoreCase("Flower"))  {
            return "flower";
        }
        // Default case: return the word unchanged
        return word;
    }

}
