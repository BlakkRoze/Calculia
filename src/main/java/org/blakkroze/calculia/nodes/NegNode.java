package org.blakkroze.calculia.nodes;

public class NegNode extends SingleArgNode {

    public NegNode() {
        super();
    }

    public NegNode(Node father) {
        super(father);
    }

    @Override
    public void evaluate() {
        setValue(father.getBigFracValue().negate());
    }

}
