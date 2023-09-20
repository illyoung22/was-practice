package org.example.calculator;


import java.util.List;

public class Calculator {
    private static final List<NewArithmeticOperator> artimeticOperators = List.of(new AdditionOperator(), new SubstractionOperator(), new DivisionOperator(), new MultiplicationOperator());

    public static int calculate(PositiveNumber op1, String operator, PositiveNumber op2) {
        //return ArithmeticOperator.calculate(op1,operator,op2);
        return  artimeticOperators.stream()
                .filter(artimeticOperators -> artimeticOperators.support(operator))
                .map(artimeticOperators -> artimeticOperators.caclulate(op1,op2))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
