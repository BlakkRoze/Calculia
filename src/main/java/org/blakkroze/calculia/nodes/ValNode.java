package org.blakkroze.calculia.nodes;

import org.blakkroze.calculia.models.BigFrac;

public class ValNode extends Node {
    private BigFrac fracValue;

    public ValNode(BigFrac value) {
        super();
        this.fracValue = value;
    }

    public void setFracValue(BigFrac value) {
        this.fracValue = value;
        invalidate();
    }

    @Override
    public void evaluate() {
        setValue(fracValue);
    }
}
