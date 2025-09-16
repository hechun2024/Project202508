package controller;

import model.Currency;

//  控制器, 用来计算从一种货币到另一种货币的转换
public class CurrencyController {

    //  传入两个货币对象和数值, 算出转换结果
    public double convert(Currency from, Currency to, double amount) {
        // 先把源货币换算成 USD, 再从 USD 换成目标货币
        double amountInUSD = amount / from.getRate();
        return amountInUSD * to.getRate();
    }
}
