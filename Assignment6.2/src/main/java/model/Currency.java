package model;

// 这是一个货币类, 用来存储缩写, 名字, 和相对USD的汇率
public class Currency {
    private String code;   // 货币缩写，比如 "USD"
    private String name;   // 货币全称，比如 "US Dollar"
    private double rate;   // 相对于USD的汇率，比如 USD=1, EUR=0.92

    public Currency(String code, String name, double rate) {
        this.code = code;
        this.name = name;
        this.rate = rate;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        //  ChoiceBox 里会显示这个
        return code + " - " + name;
    }
}
