public class LinearFunc implements Function {
    private double a;
    private double b;
    private double A;
    private double B;
    LinearFunc(double aBound,double bBound,double A,double B)throws IndexOutOfBoundsException{
        if(aBound>bBound) throw new IndexOutOfBoundsException();
        this.a=aBound;
        this.b=bBound;
        this.A=A;
        this.B=B;
    }
    @Override
    public double calc(double x)throws IndexOutOfBoundsException {
        if(x<a || x>b) throw new IndexOutOfBoundsException();
        return A*x+B;
    }
    @Override
    public double getA() {
        return a;
    }
    @Override
    public double getB() {
        return b;
    }
}
