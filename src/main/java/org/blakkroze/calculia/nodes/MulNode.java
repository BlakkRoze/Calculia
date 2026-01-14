package org.blakkroze.calculia.nodes;

public class MulNode extends TwoArgNode {

    public MulNode(){
        super();
    }

    public MulNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public void evaluate() {
        setValue(left.getBigFracValue().multiply(right.getBigFracValue()));
    }

}
