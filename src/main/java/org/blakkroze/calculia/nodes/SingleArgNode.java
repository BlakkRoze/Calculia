package org.blakkroze.calculia.nodes;

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
