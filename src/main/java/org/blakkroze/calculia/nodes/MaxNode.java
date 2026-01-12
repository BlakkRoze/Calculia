package org.blakkroze.calculia.nodes;

import org.blakkroze.calculia.models.BigFrac;

public class MaxNode extends TwoArgNode {

    public MaxNode(){
        super();
    }

    public MaxNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public void evaluate() {
        BigFrac leftVal = left.getBigFracValue();
        BigFrac rightVal = right.getBigFracValue();
        setValue(leftVal.compareTo(rightVal) >= 0 ? leftVal : rightVal);
    }

}
