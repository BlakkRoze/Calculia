// AddNode.java
class AddNode extends Node {
    private Node left, right;
    
    public AddNode(Node left, Node right) {
        super();
        this.left = left;
        this.right = right;
        left.subscribe(this);
        right.subscribe(this);
    }
    
    @Override
    public void evaluate() {
        setValue(left.getValue().add(right.getValue()));
    }
    
    @Override
    public String getDisplayName() {
        return "Add [" + left.getId() + " + " + right.getId() + "]";
    }
}

// SubNode.java
class SubNode extends Node {
    private Node left, right;
    
    public SubNode(Node left, Node right) {
        super();
        this.left = left;
        this.right = right;
        left.subscribe(this);
        right.subscribe(this);
    }
    
    @Override
    public void evaluate() {
        setValue(left.getValue().subtract(right.getValue()));
    }
    
    @Override
    public String getDisplayName() {
        return "Sub [" + left.getId() + " - " + right.getId() + "]";
    }
}

// MulNode.java
class MulNode extends Node {
    private Node left, right;
    
    public MulNode(Node left, Node right) {
        super();
        this.left = left;
        this.right = right;
        left.subscribe(this);
        right.subscribe(this);
    }
    
    @Override
    public void evaluate() {
        setValue(left.getValue().multiply(right.getValue()));
    }
    
    @Override
    public String getDisplayName() {
        return "Mul [" + left.getId() + " * " + right.getId() + "]";
    }
}

// DivNode.java
class DivNode extends Node {
    private Node left, right;
    
    public DivNode(Node left, Node right) {
        super();
        this.left = left;
        this.right = right;
        left.subscribe(this);
        right.subscribe(this);
    }
    
    @Override
    public void evaluate() {
        setValue(left.getValue().divide(right.getValue()));
    }
    
    @Override
    public String getDisplayName() {
        return "Div [" + left.getId() + " / " + right.getId() + "]";
    }
}

// MinNode.java
class MinNode extends Node {
    private Node left, right;
    
    public MinNode(Node left, Node right) {
        super();
        this.left = left;
        this.right = right;
        left.subscribe(this);
        right.subscribe(this);
    }
    
    @Override
    public void evaluate() {
        BigFrac leftVal = left.getValue();
        BigFrac rightVal = right.getValue();
        setValue(leftVal.compareTo(rightVal) <= 0 ? leftVal : rightVal);
    }
    
    @Override
    public String getDisplayName() {
        return "Min [" + left.getId() + ", " + right.getId() + "]";
    }
}

// MaxNode.java
class MaxNode extends Node {
    private Node left, right;
    
    public MaxNode(Node left, Node right) {
        super();
        this.left = left;
        this.right = right;
        left.subscribe(this);
        right.subscribe(this);
    }
    
    @Override
    public void evaluate() {
        BigFrac leftVal = left.getValue();
        BigFrac rightVal = right.getValue();
        setValue(leftVal.compareTo(rightVal) >= 0 ? leftVal : rightVal);
    }
    
    @Override
    public String getDisplayName() {
        return "Max [" + left.getId() + ", " + right.getId() + "]";
    }
}

// NegNode.java
class NegNode extends Node {
    private Node operand;
    
    public NegNode(Node operand) {
        super();
        this.operand = operand;
        operand.subscribe(this);
    }
    
    @Override
    public void evaluate() {
        setValue(operand.getValue().negate());
    }
    
    @Override
    public String getDisplayName() {
        return "Neg [" + operand.getId() + "]";
    }
}