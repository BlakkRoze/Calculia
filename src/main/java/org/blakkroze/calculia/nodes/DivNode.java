package org.blakkroze.calculia.nodes;

import org.blakkroze.calculia.models.BigFrac;

public class DivNode extends TwoArgNode {

    public DivNode(){
        super();
    }

    public DivNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public void evaluate() {
        BigFrac rightValue = right.getBigFracValue();

        if (rightValue.getTop().equals(java.math.BigInteger.ZERO)) {
            throw new ArithmeticException("Division by zero: Cannot divide by zero");
        }

        setValue(left.getBigFracValue().divide(rightValue));
    }
}
