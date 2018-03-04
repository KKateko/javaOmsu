import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FunctionCalcTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void LinearFuncCalcTest(){
       LinearFunc test = new LinearFunc(-100,100,2,1);
       assertEquals(test.calc(2.0),5.0,0.001);
    }
    @Test
    public void LinearFuncCalcException1(){
        thrown.expect(IndexOutOfBoundsException.class);
        LinearFunc test = new LinearFunc(100,-100,2,1);
        fail();
    }
    @Test
    public void LinearFuncCalcException2(){
        thrown.expect(IndexOutOfBoundsException.class);
        LinearFunc test = new LinearFunc(0,1,2,1);
        assertEquals(test.calc(2.0),5.0,0.001);
        fail();
    }

    @Test
    public void TrigonometricFuncCalcTest(){
        TrigonometricFunc test = new TrigonometricFunc(-100,100,2,1);
        assertEquals(test.calc(Math.PI/2),2.0,0.001);
    }
    @Test
    public void TrigonometricFuncCalcException1(){
        thrown.expect(IndexOutOfBoundsException.class);
        TrigonometricFunc test = new TrigonometricFunc(100,-100,2,1);
        fail();
    }
    @Test
    public void TrigonometricFuncCalcException2(){
        thrown.expect(IndexOutOfBoundsException.class);
        TrigonometricFunc test = new TrigonometricFunc(0,1,2,1);
        assertEquals(test.calc(Math.PI/2),2.0,0.001);
        fail();
    }

    @Test
    public void LinearFractionalFuncCalcTest(){
        LinearFractionalFunc test = new LinearFractionalFunc(-100,100,2,1,4,2);
        assertEquals(test.calc(2),0.5,0.001);
    }
    @Test
    public void LinearFractionalFuncCalcException1(){
        thrown.expect(IndexOutOfBoundsException.class);
        LinearFractionalFunc test = new LinearFractionalFunc(100,10,2,1,4,2);
        fail();
    }
    @Test
    public void LinearFractionalFuncCalcException2(){
        thrown.expect(IndexOutOfBoundsException.class);
        LinearFractionalFunc test = new LinearFractionalFunc(-10,10,2,1,4,2);
        assertEquals(test.calc(20),0.5,0.001);
        fail();
    }
    @Test
    public void LinearFractionalFuncCalcException3(){
        thrown.expect(ArithmeticException.class);
        LinearFractionalFunc test = new LinearFractionalFunc(-10,10,2,1,0,0);
        test.calc(20);
        fail();
    }

    @Test
    public void ExponentialFuncCalcTest(){
        ExponentialFunc test=new ExponentialFunc(-100,100,5,2);
        assertEquals(test.calc(0),7.0,0.001);
    }
    @Test
    public void ExponentialFuncCalcException1(){
        thrown.expect(IndexOutOfBoundsException.class);
        ExponentialFunc test=new ExponentialFunc(100,-100,5,2);
        fail();
    }
    @Test
    public void ExponentialFuncCalcException2(){
        thrown.expect(IndexOutOfBoundsException.class);
        ExponentialFunc test=new ExponentialFunc(-1,0,5,2);
        assertEquals(test.calc(1),7.0,0.001);
        fail();
    }
}
