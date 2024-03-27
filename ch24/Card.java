package ch24;

public class Card extends Chargeable{
    protected String cardNumber;
    protected String expireDate;
    protected Card(CardType cardType){
        super(cardType);
    }
}

class CashCard extends Card{
    private String accountNumber;
    CashCard(String accountNumber, String expireDate, String cardNumber  ){
        super(CardType.CASH);
        this.accountNumber=accountNumber;
        super.cardNumber=cardNumber;
        super.expireDate=expireDate;
    }

    @Override
    public String toString() {
        return "CashCard{" +
                "accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
class CreditCard extends Card{
    CreditCard(String expireDate, String cardNumber  ){
        super(CardType.CREDIT);
        super.cardNumber=cardNumber;
        super.expireDate=expireDate;
    }


    @Override
    public String toString() {
        return "CreditCard{" +
                "accountNumber='" + '\'' +
                '}';
    }
}
class GiftCard extends Card{
    public GiftCard(){
        super(CardType.GIFT);
    }


}
