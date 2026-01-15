package org.blakkroze.calculia.nodes;

import org.blakkroze.calculia.utils.CycleDetector;

public abstract class TwoArgNode extends Node {
    protected Node left, right;

    public TwoArgNode(){
        super();
    }

    public TwoArgNode(Node left, Node right) {
        super();
        this.left = left;
        this.right = right;
        left.subscribe(this);
        right.subscribe(this);
    }

    public void setLeft(Node newLeft) {
        if (CycleDetector.wouldCreateCycle(this, newLeft)) {
            throw new IllegalArgumentException("Cannot set left node: would create a cycle");
        }
        if(this.left != null){
            this.left.unsubscribe(this);
        }
        this.left = newLeft;
        newLeft.subscribe(this);
        this.invalidate();
    }

    public void setRight(Node newRight) {
        if (CycleDetector.wouldCreateCycle(this, newRight)) {
            throw new IllegalArgumentException("Cannot set left node: would create a cycle");
        }
        if(this.right != null) {
            this.right.unsubscribe(this);
        }
        this.right = newRight;
        newRight.subscribe(this);
        this.invalidate();
    }

    public Node getRightArgNode() {
        return this.right;
    }

    public Node getLeftArgNode() {
        return this.left;
    }
}
