package org.blakkroze.calculia.nodes;

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

    public void SetLeft(Node newLeft) {
        if(this.left != null)
            this.left.unsubscribe(this);
        this.left = newLeft;
        newLeft.subscribe(this);
        this.invalidate();
    }

    public void SetRight(Node newRight) {
        if(this.right != null)
            this.right.unsubscribe(this);
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
