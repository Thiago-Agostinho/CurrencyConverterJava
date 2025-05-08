package service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Converter {

    String myApiKey = "YOUR-API-KEY";
    String url = "https://v6.exchangerate-api.com/v6/" +  myApiKey +  "/par/" +  baseCurrency + "/" + targetCurrency + "/" + amount;
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
    HttpResponse <String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());


}
