package ensuringImmutability;

import java.util.Objects;

class Complex {

    private final float re;
    private final float im;

    private Complex(float re, float im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(float re, float im){
        return new Complex(re, im);
    }

    //only getters without setters
    public float realPart() {
        return re;
    }

    public float imaginaryPart() {
        return im;
    }

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re, im * c.im);
    }

    public Complex dividedBy(Complex c) {
        float tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp,
                (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Float.compare(complex.re, re) == 0 && Float.compare(complex.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Float.hashCode(re) + Float.hashCode(im);
    }

    @Override
    public String toString() {
        return "Complex{" +
                "re=" + re +
                ", im=" + im +
                '}';
    }
}
