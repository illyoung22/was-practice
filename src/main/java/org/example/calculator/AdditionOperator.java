package org.example.calculator;

public class AdditionOperator implements NewArithmeticOperator {
    @Override
    public boolean support(String operator) {
        return "+".equals(operator);
    }

    @Override
    public int caclulate(PositiveNumber op1, PositiveNumber op2) {
        return op1.toInt() + op2.toInt();
    }
}
