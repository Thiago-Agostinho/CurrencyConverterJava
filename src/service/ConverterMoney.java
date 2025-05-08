package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverterMoney {
    public static void converter(String baseCurrency, String targetCurrency, int amount) throws IOException, InterruptedException {

        String myApiKey = "11a21dec730c9cb6a3d96362";
        String url = "https://v6.exchangerate-api.com/v6/" + myApiKey + "/pair/" + baseCurrency + "/" + targetCurrency + "/" + amount;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        String baseCode = jsonObject.get("base_code").getAsString();
        String targetCode = jsonObject.get("target_code").getAsString();
        double conversionResult = jsonObject.get("conversion_result").getAsDouble();

        System.out.println("Moeda de origem: " + baseCode);
        System.out.println("Moeda de destino: " + targetCode);
        System.out.println("Resultado da conversão: " + conversionResult);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        System.out.println(jsonObject);
    }
}
