import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyCompareAPI_NoJSON {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入消费金额（欧元）：");
        BigDecimal euroAmount = sc.nextBigDecimal();

        try {
            // EUR→CNY 和 EUR→USD
            URL url1 = new URL("https://open.er-api.com/v6/latest/EUR");
            HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
            conn1.setRequestMethod("GET");

            BufferedReader in1 = new BufferedReader(new InputStreamReader(conn1.getInputStream()));
            StringBuilder content1 = new StringBuilder();
            String line;
            while ((line = in1.readLine()) != null) {
                content1.append(line);
            }
            in1.close();

            String response1 = content1.toString();
            BigDecimal eurToCny = extractRate(response1, "CNY");
            BigDecimal eurToUsd = extractRate(response1, "USD");

            // USD→CNY
            URL url2 = new URL("https://open.er-api.com/v6/latest/USD");
            HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
            conn2.setRequestMethod("GET");

            BufferedReader in2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
            StringBuilder content2 = new StringBuilder();
            while ((line = in2.readLine()) != null) {
                content2.append(line);
            }
            in2.close();

            String response2 = content2.toString();
            BigDecimal usdToCny = extractRate(response2, "CNY");

            // ✨ 统一精度到 4 位小数
            eurToCny = setScale4(eurToCny);
            eurToUsd = setScale4(eurToUsd);
            usdToCny = setScale4(usdToCny);

            if (eurToCny.compareTo(BigDecimal.ZERO) <= 0 ||
                    eurToUsd.compareTo(BigDecimal.ZERO) <= 0 ||
                    usdToCny.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("⚠️ 汇率解析失败，请检查 API 返回格式。");
                return;
            }

            // 计算
            BigDecimal directCny = euroAmount.multiply(eurToCny);
            BigDecimal usdAmount = euroAmount.multiply(eurToUsd);
            BigDecimal viaUsdCny = usdAmount.multiply(usdToCny);

            // 保留两位小数
            directCny = directCny.setScale(2, RoundingMode.HALF_UP);
            viaUsdCny = viaUsdCny.setScale(2, RoundingMode.HALF_UP);
            BigDecimal diff = directCny.subtract(viaUsdCny).setScale(2, RoundingMode.HALF_UP);

            // 输出
            System.out.printf("统一到4位小数后的汇率: EUR→CNY=%s, EUR→USD=%s, USD→CNY=%s%n",
                    eurToCny, eurToUsd, usdToCny);
            System.out.printf("欧元直兑人民币: %s RMB%n", directCny);
            System.out.printf("欧元经美元再兑人民币: %s RMB%n", viaUsdCny);
            System.out.printf("差额: %s RMB%n", diff);

        } catch (Exception e) {
            System.out.println("❌ 出现错误: " + e.getMessage());
        }

        sc.close();
    }

    // 提取汇率
    private static BigDecimal extractRate(String json, String currency) {
        String key = "\"" + currency + "\":";
        int start = json.indexOf(key);
        if (start == -1) return BigDecimal.valueOf(-1);
        start += key.length();
        int end = start;
        while (end < json.length() &&
                (Character.isDigit(json.charAt(end)) || json.charAt(end) == '.')) {
            end++;
        }
        try {
            return new BigDecimal(json.substring(start, end));
        } catch (Exception e) {
            return BigDecimal.valueOf(-1);
        }
    }

    // 工具函数：统一精度为 4 位小数
    private static BigDecimal setScale4(BigDecimal value) {
        return value.setScale(4, RoundingMode.HALF_UP);
    }
}
