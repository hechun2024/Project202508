// task 3.4_1
import java.io.*;
import java.net.*;

public class Task1 {
    public static void main(String[] args) {
        String urlStr = "https://users.metropolia.fi/~jarkkov/temploki.csv";
        double sum = 0;
        int count = 0;

        try {
            URL url = new URL(urlStr);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = reader.readLine(); // header
            String[] headers = line.split(";");
            int colIndex = -1;
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equalsIgnoreCase("UlkoTalo")) {
                    colIndex = i;
                    break;
                }
            }

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts[0].startsWith("01.01.2023")) { // date
                    double temp = Double.parseDouble(parts[colIndex].replace(",", "."));
                    sum += temp;
                    count++;
                }
            }

            reader.close();
            System.out.println("Average UlkoTalo temp on 2023-01-01: " + (sum / count));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
