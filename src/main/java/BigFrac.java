import java.math.BigInteger;

public class BigFrac {
    private BigInteger top;
    private BigInteger bottom;
    
    public BigFrac(long top, long bottom) {
        this(BigInteger.valueOf(top), BigInteger.valueOf(bottom));
    }
    
    public BigFrac(BigInteger top, BigInteger bottom) {
        if (bottom.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Division by zero");
        }
        BigInteger gcd = top.gcd(bottom);
        this.top = top.divide(gcd);
        this.bottom = bottom.divide(gcd);
        
        if (this.bottom.compareTo(BigInteger.ZERO) < 0) {
            this.top = this.top.negate();
            this.bottom = this.bottom.negate();
        }
    }
    
    public BigInteger getTop() { return top; }
    public BigInteger getBottom() { return bottom; }
    
    public BigFrac add(BigFrac other) {
        BigInteger newTop = this.top.multiply(other.bottom).add(other.top.multiply(this.bottom));
        BigInteger newBottom = this.bottom.multiply(other.bottom);
        return new BigFrac(newTop, newBottom);
    }
    
    public BigFrac subtract(BigFrac other) {
        BigInteger newTop = this.top.multiply(other.bottom).subtract(other.top.multiply(this.bottom));
        BigInteger newBottom = this.bottom.multiply(other.bottom);
        return new BigFrac(newTop, newBottom);
    }
    
    public BigFrac multiply(BigFrac other) {
        return new BigFrac(this.top.multiply(other.top), this.bottom.multiply(other.bottom));
    }
    
    public BigFrac divide(BigFrac other) {
        return new BigFrac(this.top.multiply(other.bottom), this.bottom.multiply(other.top));
    }
    
    public BigFrac negate() {
        return new BigFrac(this.top.negate(), this.bottom);
    }
    
    public int compareTo(BigFrac other) {
        BigInteger left = this.top.multiply(other.bottom);
        BigInteger right = other.top.multiply(this.bottom);
        return left.compareTo(right);
    }
    
    @Override
    public String toString() {
        if (bottom.equals(BigInteger.ONE)) {
            return top.toString();
        }
        return top + "/" + bottom;
    }
}