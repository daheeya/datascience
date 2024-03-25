package ch22.q2;

public class Nomal extends Customer{

    public Nomal(String id, String name){
        super(id,name,Grade.NOMAL);
    }

    @Override
    public void setPoint(int price) {
        int priceBonus = (int) (price* this.getGrade().getBonusRate() );
        super.point+= priceBonus;
        System.out.println("적립된 포인트: "+priceBonus+"누적 포인트: "+point);
    }

    @Override
    public void purchase(int price) {
        setPoint(price);

        System.out.println("지불금액: "+price);
    }
}
