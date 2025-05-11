package application;

import menu.CurrencyMenu;
import menu.MenuDisplay;
import service.MoneyConverter;
import service.FileLogger;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner reading = new Scanner(System.in);
        double amount;

        while (true){
            MenuDisplay.presentation();
            System.out.println("Qual conversão você gostaria de fazer?");
            String option = reading.nextLine();

            if (CurrencyMenu.isExitOption(option)) {
                System.out.println("Programa encerrado...");
                break;
            }

            if (!CurrencyMenu.isValidOption(option)) {
                System.out.println("Escolha uma opção válida!");
                continue;
            }

            String[] currencies = CurrencyMenu.getCurrencies(option);
            String baseCurrency = currencies[0];
            String targetCurrency = currencies[1];

            System.out.println("Qual o valor que desejado da conversão?");
            try {
                amount = Double.parseDouble(reading.nextLine());
                if (amount <= 0) {
                    System.out.println("O valor deve ser positivo.");
                    continue;
                }
                String result = MoneyConverter.converter(baseCurrency,targetCurrency, amount);
                System.out.println(result);

                FileLogger.saveToFile(result, "Conversor.txt");

            } catch (NumberFormatException e){
                System.out.println("Valor inválido. Tente novamente com um número.");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }
        reading.close();
    }
}