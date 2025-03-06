package calculator;

public class TaxBracket {
    private String status;
    private double income;

    private int percent;

    public TaxBracket(String status, double income) {
        this.status = status;
        this.income = income;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setIncome(double income) {
        this.income = income;
    }

    public double calculateTaxBracket() {
        if(status.equalsIgnoreCase("Married")) {
            if (income > 0 && income < 14600) {
                percent = 0;
            } else if(income > 14600 && income < 26200) {
                percent = 10;
            } else if (income > 26200 && income < 61750) {
                percent = 12;
            } else if (income > 61750 && income < 115125) {
                percent = 22;
            } else if (income > 115125 && income < 206550) {
                percent = 24;
            } else if (income > 206550 && income < 258325 ) {
                percent = 32;
            } else if (income > 258325 && income < 380200) {
                percent = 35;
            } else {
                percent = 37;
            }
        } else {
            if (income > 0 && income < 7300) {
                percent = 0;
            } else if(income > 7300 && income < 13100) {
                percent = 10;
            } else if (income > 13100 && income < 30875) {
                percent = 12;
            } else if (income > 30875 && income < 57563) {
                percent = 22;
            } else if (income > 57563 && income < 103275) {
                percent = 24;
            } else if (income > 103275 && income < 129163) {
                percent = 32;
            } else if (income > 129163 && income < 311975) {
                percent = 35;
            } else {
                percent = 37;
            }
        }
        return percent;
    }
    public double calculateTaxAmount() {
        return income * (percent / 100.0);
    }


}
