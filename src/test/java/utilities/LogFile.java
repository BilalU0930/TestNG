package utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogFile {

    public static void main(String[] args) {
        String logFilePath = "selenium.log"; // Log dosyasının adı ve yolu

        try {
            FileWriter fileWriter = new FileWriter(logFilePath, true); // true: mevcut dosyanın sonuna ekle
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Logları dosyaya yazma
            bufferedWriter.write("TEST PASSED");
            bufferedWriter.newLine(); // Yeni satıra geç

            bufferedWriter.close(); // Dosyayı kapat
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
