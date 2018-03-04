public class Integral implements Functional {
    private double a;
    private double b;
    public Integral(double aBond,double bBond)throws IndexOutOfBoundsException{
        if(aBond>bBond) throw new IndexOutOfBoundsException();
        this.a=aBond;
        this.b=bBond;
    }
    @Override
    public double execute(Function func)throws IndexOutOfBoundsException {

        final int n=100;//число разбиений
        final double eps=0.0001;//точность
        double value=0;
        double h=(b-a)/n;//шаг

        if(a<func.getA()||b>func.getB()) throw new IndexOutOfBoundsException();
        for(int i=0;i<n;i++) {
            value += func.calc(a + h * (i + 0.5));
        }
        value=Math.rint(1000*h*value)/1000;
        return value;
    }
}
