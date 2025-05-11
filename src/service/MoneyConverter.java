package service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MoneyConverter {
    public static String converter(String baseCurrency, String targetCurrency, double amount) throws IOException, InterruptedException {

        String myApiKey = "YOUR-API-KEY";
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

        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        String resultText = String.format("[%s] %.2f %s => %.2f %s",
                timeStamp,amount, baseCode, conversionResult, targetCode);
        return resultText;
    }
}
