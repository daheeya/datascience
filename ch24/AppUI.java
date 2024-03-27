package ch24;

import java.util.List;

public class AppUI {
    public static void main(String[] args) {
        SinhanCard.getInstance().createUser("dahee@gmail.com");
        SinhanCard.getInstance().createCard(1L,CardType.CREDIT);
        List<Chargeable> myCards = SinhanCard.getInstance().findChargeable(1L);

        // 신용카드를 사용하려면
        /*
        for(var card: myCards){ //신한카드에서 카드를 받아올 수 있지만 강사님은 귀찮아서 . 걍 카드목록 for문 돌려서.. 그리고 카드 목록을 User가 가져도 됨. 그건 그냥 구현상의 다름?
            if(card instanceof CreditCard) ((CreditCard) card).payment(3000);
            card.cardPaymentHistories();
            break;
        }*/
        myCards.get(0).payment(4000);
        myCards.get(0).payment(5000);
        myCards.get(0).cardPaymentHistories();

        SinhanCard.getInstance().createCard(1L,CardType.CREDIT);
        var myCreditCard2 = SinhanCard.getInstance().findChargeable(1L).get(1);
        myCreditCard2.payment(8000);
        myCreditCard2.cardPaymentHistories();


        SinhanCard.getInstance().createCard(1L,CardType.CASH);
        var myCashCard1 = SinhanCard.getInstance().findChargeable(1L).get(2);
        System.out.println(SinhanCard.getInstance().findChargeable(1L));
        myCashCard1.payment(10000);
        myCashCard1.cardPaymentHistories();

    }
}
