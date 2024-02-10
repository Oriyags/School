package il.co.oriya.model;
public class Calculator {
    private int operand1;
    private int operand2;
    private char operator;

    public Calculator() {
        operand1 = 0;
        operand2 = 0;
        operator = '+';
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public int calculate() {
        int result = 0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 != 0) {
                    result = operand1 / operand2;
                }
                break;
        }
        return result;
    }
}
