import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CurrencyCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 输入金额
        System.out.print("请输入消费金额（欧元）：");
        BigDecimal euroAmount = sc.nextBigDecimal();

        // 输入汇率
        System.out.print("请输入 EUR→CNY 汇率：");
        BigDecimal eurToCny = sc.nextBigDecimal();

        System.out.print("请输入 EUR→USD 汇率：");
        BigDecimal eurToUsd = sc.nextBigDecimal();

        System.out.print("请输入 USD→CNY 汇率：");
        BigDecimal usdToCny = sc.nextBigDecimal();

        // ✨ 统一精度到 4 位小数
        eurToCny = setScale4(eurToCny);
        eurToUsd = setScale4(eurToUsd);
        usdToCny = setScale4(usdToCny);

        // 方式1: 欧元→人民币
        BigDecimal directCny = euroAmount.multiply(eurToCny);

        // 方式2: 欧元→美元→人民币
        BigDecimal usdAmount = euroAmount.multiply(eurToUsd);
        BigDecimal viaUsdCny = usdAmount.multiply(usdToCny);

        // 保留两位小数
        directCny = directCny.setScale(2, RoundingMode.HALF_UP);
        viaUsdCny = viaUsdCny.setScale(2, RoundingMode.HALF_UP);
        BigDecimal diff = directCny.subtract(viaUsdCny).setScale(2, RoundingMode.HALF_UP);

        // 输出结果
        System.out.printf("统一到4位小数后的汇率: EUR→CNY=%s, EUR→USD=%s, USD→CNY=%s%n",
                eurToCny, eurToUsd, usdToCny);
        System.out.printf("欧元直兑人民币: %s RMB%n", directCny);
        System.out.printf("欧元经美元再兑人民币: %s RMB%n", viaUsdCny);
        System.out.printf("差额: %s RMB%n", diff);

        sc.close();
    }

    // 工具函数：统一精度为 4 位小数
    private static BigDecimal setScale4(BigDecimal value) {
        return value.setScale(4, RoundingMode.HALF_UP);
    }
}
