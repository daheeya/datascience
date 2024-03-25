package ch22.q2;

public class Royal extends Customer{


    public Royal(String id, String name){
        super(id,name,Grade.ROYAL);
    }


    @Override
    public void purchase(int price) {
        int discountPirce = (int)(price * this.getGrade().getDiscountRate());

        int pricePoint=(int)(price*grade.getBonusRate());
        super.point+= pricePoint;

        System.out.println("지불 금액: "+ discountPirce +"적립된 포인트 : "+ pricePoint+"누적 적립금: "+ point);
    }
}
