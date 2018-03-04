import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FunctionalIntegralTest {
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    @Test
    public void LinearFuncIntegralTest(){
        Integral functional=new Integral(0,1.5);
        LinearFunc test = new LinearFunc(-100,100,2,1);
        assertEquals(functional.execute(test),3.75,0.001);
    }
    @Test
    public void LinearFuncIntegralException1(){
        thrown.expect(IndexOutOfBoundsException.class);
        Integral functional=new Integral(2.5,1.5);
        fail();
    }
    @Test
    public void LinearFuncIntegralException2(){
        thrown.expect(IndexOutOfBoundsException.class);
        Integral functional=new Integral(0,1.5);
        LinearFunc test = new LinearFunc(-1,1,2,1);
        functional.execute(test);

        fail();
    }

    @Test
    public void TrigonometricFuncIntegralTest(){
        Integral functional=new Integral(-1,1);
        TrigonometricFunc test = new TrigonometricFunc(-100,100,2,1);
        assertEquals(functional.execute(test),0.0,0.001);
    }
    @Test
    public void TrigonometricFuncIntegralException1(){
        thrown.expect(IndexOutOfBoundsException.class);
        Integral functional=new Integral(2.5,1.5);
        fail();
    }
    @Test
    public void TrigonometricFuncIntegralException2(){
        thrown.expect(IndexOutOfBoundsException.class);
        Integral functional=new Integral(0,1.5);
        TrigonometricFunc test = new TrigonometricFunc(-1,1,2,1);
        functional.execute(test);
        fail();
    }

    @Test
    public void LinearFractionalFuncIntegralTest(){
        Integral functional=new Integral(0,1);
        LinearFractionalFunc test = new LinearFractionalFunc(-100,100,2,1,4,2);
        assertEquals(functional.execute(test),0.5, 0.001);
    }
    @Test
    public void LinearFractionalFuncIntegralException1(){
        thrown.expect(IndexOutOfBoundsException.class);
        Integral functional=new Integral(2.5,1.5);
        fail();
    }
    @Test
    public void LinearFractionalFuncIntegralException2(){
        thrown.expect(IndexOutOfBoundsException.class);
        Integral functional=new Integral(-2,1.5);
        LinearFractionalFunc test = new LinearFractionalFunc(0,1,2,1,3,4);
        functional.execute(test);
        fail();
    }

    @Test
    public void ExponentialFuncIntegralTest(){
        Integral functional=new Integral(0,2);
        ExponentialFunc test=new ExponentialFunc(-100,100,5,2);
        assertEquals(functional.execute(test),35.945,0.001);
    }
    @Test
    public void ExponentialFuncIntegralException1(){
        thrown.expect(IndexOutOfBoundsException.class);
        Integral functional=new Integral(2,1);
        fail();
    }
    @Test
    public void ExponentialFuncIntegralException2(){
        thrown.expect(IndexOutOfBoundsException.class);
        Integral functional=new Integral(-2,1.5);
        ExponentialFunc test = new ExponentialFunc(0,1,2,1);
        functional.execute(test);
        fail();
    }
}
