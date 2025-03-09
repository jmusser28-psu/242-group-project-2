package calculator;

import util.GetString;

public class FilingStatus {

    String status;
    public FilingStatus() {
        // Constructs the class, and determines and sets filing status
        boolean valid = false;
        System.out.print("What is your filing status? (Single, Married): ");
        // Verifies that the user input is valid
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
        // Sets the filing status
        boolean valid = false;
        System.out.print("What is your filing status? (Single, Married): ");
        // Verifies that the user input is valid
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
        // Gets (returns) the status
        return status;
    }

}
