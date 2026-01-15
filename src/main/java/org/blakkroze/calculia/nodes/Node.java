package org.blakkroze.calculia.nodes;

import org.blakkroze.calculia.models.BigFrac;

import java.util.ArrayList;
import java.util.List;

public abstract class Node implements NodeSubscriber {
    private int id;
    private boolean evaluated;
    private BigFrac value;
    private List<NodeSubscriber> subscribers;

    public Node() {
        this.evaluated = false;
        this.subscribers = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId() { return String.valueOf(id); }

    public int getIntId() { return id; }

    public boolean isEvaluated() {
        return evaluated;
    }

    public String getValue() {
        if (!evaluated) {
            evaluate();
        }
        return value.toString();
    }

    public BigFrac getBigFracValue() {
        if (!evaluated) {
            evaluate();
        }
        return value;
    }

    protected void setValue(BigFrac value) {
        this.value = value;
        this.evaluated = true;
    }

    public void invalidate() {
        if (evaluated) {
            evaluated = false;
            notifySubscribers();
        }
    }

    public void subscribe(NodeSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(NodeSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    private void notifySubscribers() {
        for (NodeSubscriber subscriber : subscribers) {
            subscriber.update();
        }
    }

    @Override
    public void update() {
        if(evaluated)
            invalidate();
    }

    public abstract void evaluate();
}
