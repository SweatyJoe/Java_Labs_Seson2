import java.math.BigInteger;

public class Bank {
    private String name;
    private Currency currency;

    public Bank(String name, Currency currency) {
        this.name = name;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", currency=" + currency +
                '}';
    }
}

class Currency {
    private String name;
    private int units;
    private Range range;

    public Currency(String name, int units, Range range) {
        this.name = name;
        this.units = units;
        this.range = range;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", units=" + units +
                ", range=" + range +
                '}';
    }
}

class Range {
    private int minAmount;
    private BigInteger maxAmount;
    private float buy;
    private float sell;

    public Range(int minAmount, BigInteger maxAmount, float buy, float sell) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.buy = buy;
        this.sell = sell;
    }

    @Override
    public String toString() {
        return "Range{" +
                "minAmount=" + minAmount +
                ", maxAmount=" + maxAmount +
                ", buy=" + buy +
                ", sell=" + sell +
                '}';
    }
}
