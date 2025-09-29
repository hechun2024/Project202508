package controller;

import entity.Currency;

/**
 * Controller: handles conversion logic.
 */
public class CurrencyController {

    public double convert(Currency from, Currency to, double amount) {
        if (from == null || to == null) return -1;        // 如果源货币或目标货币为空，返回 -1 表示错误
        if (from.getRate() <= 0 || to.getRate() <= 0) return -1;   // 如果汇率小于等于 0，说明数据不合法，返回 -1

        // Convert from source currency -> USD -> target currency
        // 转换逻辑：
        // 1. 先将源货币转换成 "美元" (USD)
        //    源金额 ÷ 源货币汇率 = 对应的美元金额
        double amountInUSD = amount / from.getRate();
        // 2. 再把美元金额换算成目标货币
        //    美元金额 × 目标货币汇率 = 转换后的目标货币金额
        return amountInUSD * to.getRate();
    }
}
