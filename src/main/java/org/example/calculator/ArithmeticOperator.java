package org.example.calculator;

import java.util.Arrays;

public enum ArithmeticOperator {
    ADDITION("+"){
        @Override
        public int arithmeticCalculator(int op1, int op2) {
            return op1 + op2;
        }
    }, SUBSTRACTION("-") {
        @Override
        public int arithmeticCalculator(int op1, int op2) {
            return op1 - op2;
        }
    },MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculator(int op1, int op2) {
            return op1 * op2;
        }
    }, DIVISION("/") {
        @Override
        public int arithmeticCalculator(int op1, int op2) {
            return op1 / op2;
        }
    };

    private final String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }


    //추상메서드
    public abstract int arithmeticCalculator(final int op1, final int op2);

    public static int calculate(int op1, String operator, int op2) {
       ArithmeticOperator arithmeticOperator=Arrays.stream(values())
               .filter(v ->v.operator.equals(operator))
               .findFirst()
               .orElseThrow(()->new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
       return arithmeticOperator.arithmeticCalculator(op1, op2);
    }
}
