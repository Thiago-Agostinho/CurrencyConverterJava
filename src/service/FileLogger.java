package service;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {
    public static void saveToFile(String content, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(content + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o resultado no arquivo: " + filename);
        }
    }
}