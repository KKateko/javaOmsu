public class LinearFractionalFunc implements Function {
    private double a;
    private double b;
    private double A;
    private double B;
    private double C;
    private double D;
    LinearFractionalFunc(double aBound,double bBound,double A,double B,double C,double D)throws IndexOutOfBoundsException{
        if(aBound>bBound) throw new IndexOutOfBoundsException();
        this.a=aBound;
        this.b=bBound;
        this.A=A;
        this.B=B;
        this.C=C;
        this.D=D;

    }
    @Override
    public double calc(double x)throws ArithmeticException, IndexOutOfBoundsException{
        if((C==0 && D==0)||(C*x+D==0)) throw new ArithmeticException();
        if(x<a|| x>b) throw new IndexOutOfBoundsException();
        return (A*x+B)/(C*x+D);
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
