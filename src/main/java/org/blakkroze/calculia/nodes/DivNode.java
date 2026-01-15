package org.blakkroze.calculia.nodes;

import org.blakkroze.calculia.models.BigFrac;
import javafx.application.Platform;

public class DivNode extends TwoArgNode {

    private Runnable errorCallback;

    public DivNode(){
        super();
    }

    public DivNode(Node left, Node right) {
        super(left, right);
    }

    public void setErrorCallback(Runnable callback) {
        this.errorCallback = callback;
    }

    @Override
    public void evaluate() {
        BigFrac rightValue = right.getBigFracValue();

        if (rightValue.getTop().equals(java.math.BigInteger.ZERO)) {
            if (errorCallback != null) {
                Platform.runLater(errorCallback);
            }
            throw new ArithmeticException("Division by zero");
        }

        setValue(left.getBigFracValue().divide(rightValue));
    }
}
