package org.blakkroze.calculia.nodes;

public class DivNode extends TwoArgNode {

    public DivNode(){
        super();
    }

    public DivNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public void evaluate() {
        setValue(left.getBigFracValue().divide(right.getBigFracValue()));
    }
}
