package ch22.q2_solution;

public enum Grade {
    NOMAL(0.0, 0.01),
    ROYAL(0.05, 0.05);
    private final double discountRate;
    private final double bonusRate;
    Grade(double discountRate, double bonusRate){
        this.bonusRate=bonusRate;
        this.discountRate=discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public double getBonusRate() {
        return bonusRate;
    }
}
