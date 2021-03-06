public class Money implements MoneyExpression {
    protected int amount;
    protected String currency;
    Money times(int multiplier){
        return new Money(amount * multiplier, currency);
    }
    Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }
    static Money dollar (int amount){
        return new Money(amount, "USD");
    }

    static Money franc (int amount){
        return new Money(amount, "CHF");
    }

    String currency(){
        return currency;
    }
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && this.currency().equals(money.currency());
    }
    MoneyExpression plus(Money addend){
        return new Sum(this, addend);
    }
}
