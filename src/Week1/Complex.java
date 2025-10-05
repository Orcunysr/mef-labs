package Week1;

public class Complex implements Comparable<Complex>, Cloneable {
    private double a;
    private double b;

    Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getRealPart() {
        return a;
    }

    public double getImaginaryPart() {
        return b;
    }

    public Complex add(Complex c) {
        double real = this.a + c.a;
        double imag = this.b + c.b;
        return new Complex(real, imag);
    }

    public Complex subtract(Complex c) {
        double real = this.a - c.a;
        double imag = this.b - c.b;
        return new Complex(real, imag);
    }

    public Complex multiply(Complex c) {
        double real = this.a * c.a - this.b * c.b;
        double imag = this.a * c.b + this.b * c.a;
        return new Complex(real, imag);
    }

    public Complex divide(Complex c) {
        double denominator = c.a * c.a + c.b * c.b;
        double real = (this.a * c.a + this.b * c.b) / denominator;
        double imag = (this.b * c.a - this.a * c.b) / denominator;
        return new Complex(real, imag);
    }

    public double abs() {
        return Math.sqrt(a * a + b * b);
    }

    @Override
    public int compareTo(Complex c) {
        return Double.compare(this.abs(), c.abs());
    }

    @Override
    public String toString() {
        return a + " + " + b + "i";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Complex)) return false;
        Complex c = (Complex) o;
        return Double.compare(a, c.a) == 0 && Double.compare(b, c.b) == 0;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new Complex(this.a, this.b);
        }
    }
}