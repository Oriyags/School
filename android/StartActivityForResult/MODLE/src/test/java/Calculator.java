public class Calculator {

    // Fields
    private int result;

    // Constructors
    public Calculator() {
        this.result = 0;
    }

    public Calculator(int initialValue) {
        this.result = initialValue;
    }

    // Methods for addition and subtraction
    public int add(int num1, int num2) {
        result = num1 + num2;
        return result;
    }

    public int subtract(int num1, int num2) {
        result = num1 - num2;
        return result;
    }

    // Additional methods
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    // Utility method to clear the result
    public void clearResult() {
        this.result = 0;
    }
}