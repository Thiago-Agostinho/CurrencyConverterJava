package menu;

import java.util.HashMap;
import java.util.Map;

public class CurrencyMenu {

    private static final Map<String, String[]> currencyOptions = new HashMap<>();

    static {
        currencyOptions.put("1", new String[]{"USD","BRL"});
        currencyOptions.put("2", new String[]{"BRL","USD"});
        currencyOptions.put("3", new String[]{"USD","JPY"});
        currencyOptions.put("4", new String[]{"JPY","USD"});
        currencyOptions.put("5", new String[]{"USD","CNY"});
        currencyOptions.put("6", new String[]{"CNY","USD"});
        currencyOptions.put("7", new String[]{"USD","RUB"});
        currencyOptions.put("8", new String[]{"RUB","USD"});
    }

    public static boolean isExitOption(String option){
        return "0".equals(option);
    }
    public static boolean isValidOption(String option) {
        return currencyOptions.containsKey(option);
    }
    public static String[] getCurrencies(String option){
        return currencyOptions.get(option);
    }
}
