package com.pluralsight.calcengine;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private char opCode;
    public double result;
    private static int numberOfCalculations;
    private static double sumOfResults;

    public MathEquation() {}

    public MathEquation(char opCode) {
        this.opCode = opCode;
    }

    public MathEquation(char opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    //because we declared fields above, we don't need to pass them as params in our execute method
    public void execute() {
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = rightVal !=0 ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
                break;
        }
        numberOfCalculations++;
        sumOfResults += result;
    }

    public void execute(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;

        execute();
    }

    public static double getAverageResult() {
        return sumOfResults / numberOfCalculations;
    }
}
