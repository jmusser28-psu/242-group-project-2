package calculator;

import util.GetString;

public class FilingStatus {

    String status;
    public FilingStatus() {
        boolean valid = false;
        System.out.print("What is your filing status? (Single, Married): ");
        while (!valid) {
            this.status = GetString.get();
            if (status.equalsIgnoreCase("Single")) {
                valid = true;
            }
            else if (status.equalsIgnoreCase("Married")) {
                valid = true;
            }
            else {
                System.out.print("Please enter a valid status: ");
                valid = false;
            }
        }

    }
    public void setStatus() {
        boolean valid = false;
        System.out.print("What is your filing status? (Single, Married): ");
        while (!valid) {
            this.status = GetString.get();
            if (status.equalsIgnoreCase("Single")) {
                valid = true;
            }
            else if (status.equalsIgnoreCase("Married")) {
                valid = true;
            }
            else {
                System.out.print("Please enter a valid status: ");
                valid = false;
            }
        }
    }

    public String getStatus() {
        return status;
    }

}
