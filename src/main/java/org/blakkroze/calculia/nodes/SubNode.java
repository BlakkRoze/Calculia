package org.blakkroze.calculia.nodes;

public class SubNode extends TwoArgNode {

    public SubNode(){
        super();
    }

    public SubNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public void evaluate() {
        setValue(left.getBigFracValue().subtract(right.getBigFracValue()));
    }

}
