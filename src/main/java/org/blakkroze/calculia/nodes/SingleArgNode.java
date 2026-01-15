package org.blakkroze.calculia.nodes;

import org.blakkroze.calculia.utils.CycleDetector;

public abstract class SingleArgNode extends Node {
    protected Node father;

    public SingleArgNode(){
        super();
    }

    public SingleArgNode(Node father) {
        super();
        this.father = father;
        father.subscribe(this);
    }

    public void setFather(Node newFather) {
        if (CycleDetector.wouldCreateCycle(this, newFather)) {
            throw new IllegalArgumentException("Cannot set left node: would create a cycle");
        }
        if(this.father != null) {
            this.father.unsubscribe(this);
        }
        this.father = newFather;
        newFather.subscribe(this);
        this.invalidate();
    }

    public Node getArgNode() {
        return this.father;
    }

}
