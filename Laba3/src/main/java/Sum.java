public class Sum implements Functional {
    private double a;
    private double b;
    public Sum(double aBond,double bBond)throws IndexOutOfBoundsException{
        if(aBond>bBond) throw new IndexOutOfBoundsException();
        this.a=aBond;
        this.b=bBond;
    }
    @Override
    public double execute(Function func)throws IndexOutOfBoundsException{
        if(a<func.getA() || b>func.getB()) throw new IndexOutOfBoundsException();
        double ans=0;
        ans+=func.calc(a)+func.calc((a+b)/2)+func.calc(b);
        return ans;
    }
}
