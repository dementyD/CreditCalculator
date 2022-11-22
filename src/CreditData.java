public class CreditData{

    private double sum;
    private double pay;
    private double bet;
    private String type;

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSum() {
        return sum;
    }

    public double getPay() {
        return pay;
    }

    public double getBet() {
        return bet;
    }

    public String getType() {
        return type;
    }

    void countCredit() {
        double sumMonth = sum / pay;
        double payYear = pay * 12;
        double firstPercent = 0;
        double finishPercent = 0;
        double savePercent = 0;
        double percent;
        double result;

        if (sumMonth <= 12) {

            if (type.equalsIgnoreCase(CreditCalculator.HUMAN)) {
                result = sum * (bet / 100);
                System.out.println(Math.ceil(result));
            }
            if (type.equalsIgnoreCase(CreditCalculator.BUSINESS)) {
                System.out.println(0.0);
            }
        } else if (sumMonth > 12) {

            if (type.equalsIgnoreCase(CreditCalculator.HUMAN)) {
                firstPercent = sum * (bet / 100);
                sum += firstPercent;
            }
            do {
                percent = 0;

                sum = sum - payYear;
                percent = sum * (bet / 100);
                sum = sum + percent;

                savePercent = percent;
                finishPercent = savePercent + finishPercent;

            } while (sum >= payYear);
            System.out.println(Math.ceil(firstPercent + finishPercent));
        }
    }
}


