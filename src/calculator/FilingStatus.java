package calculator;

import util.GetString;

public class FilingStatus {

    String status;
    public FilingStatus() {
        System.out.print("What is your filing status (Single, Married)");
        this.status = GetString.get();
    }
    public void setStatus() {
        System.out.print("What is your filing status (Single, Married)");
        String userInput = GetString.get();
        String status = "";
        boolean valid = false;
        while (!valid) {
            if (userInput.equalsIgnoreCase("Single")) {
                status = userInput;
                valid = true;
            }
            else if (userInput.equalsIgnoreCase("Married")) {
                status = userInput;
                valid = true;
            }
            else {
                valid = false;
                userInput = GetString.get();
            }
        }
    }

    public String getStatus() {
        return status;
    }

}
