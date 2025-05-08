package application;

import service.ConverterMoney;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String baseCurrency = "JPY";
        String targetCurrency = "BRL" ;
        int amount = 2500 ;

        ConverterMoney.converter(baseCurrency,targetCurrency, amount);

    }
}