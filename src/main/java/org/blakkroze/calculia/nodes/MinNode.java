package org.blakkroze.calculia.nodes;

import org.blakkroze.calculia.models.BigFrac;

public class MinNode extends TwoArgNode {

    public MinNode(){
        super();
    }

    public MinNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public void evaluate() {
        BigFrac leftVal = left.getBigFracValue();
        BigFrac rightVal = right.getBigFracValue();
        setValue(leftVal.compareTo(rightVal) <= 0 ? leftVal : rightVal);
    }

}
