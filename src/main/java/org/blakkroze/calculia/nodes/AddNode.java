package org.blakkroze.calculia.nodes;

public class AddNode extends TwoArgNode {

    public AddNode(){
        super();
    }

    public AddNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public void evaluate() {
        setValue(left.getBigFracValue().add(right.getBigFracValue()));
    }

}
