import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class FunctionalSumTest {
    @Rule
    public ExpectedException thrown= ExpectedException.none();
        @Test
        public void LinearFuncSumTest(){
            Sum functional=new Sum(-1,1);
            LinearFunc test = new LinearFunc(-100,100,2,1);
            assertEquals(functional.execute(test),3.0,0.001);
        }
        @Test
        public void LinearFuncSumException1(){
            thrown.expect(IndexOutOfBoundsException.class);
            Sum functional=new Sum(1,-1);
            fail();
        }
        @Test
        public void LinearFuncSumException2(){
            thrown.expect(IndexOutOfBoundsException.class);
            Sum functional=new Sum(-1,10);
            LinearFunc test = new LinearFunc(0,1,2,1);
            functional.execute(test);
            fail();
        }

        @Test
        public void TrigonometricFuncSumTest(){
            Sum functional=new Sum(-1,1);
            TrigonometricFunc test = new TrigonometricFunc(-100,100,2,1);
            assertEquals(functional.execute(test),0.0,0.001);
        }
        @Test
        public void TrigonometricFuncSumException1() {
            thrown.expect(IndexOutOfBoundsException.class);
            Sum functional = new Sum(1, -1);
            fail();
        }
        @Test
        public void TrigonometricFuncSumException2() {
            thrown.expect(IndexOutOfBoundsException.class);
            Sum functional = new Sum(-1, 10);
            TrigonometricFunc test = new TrigonometricFunc(0,100,2,1);
            functional.execute(test);
            fail();
        }

        @Test
        public void LinearFractionalFuncSumTest(){

            Sum functional=new Sum(-1,1);
            LinearFractionalFunc test = new LinearFractionalFunc(-100,100,2,1,4,2);
            assertEquals(functional.execute(test),1.5,0.001);
        }
        @Test
        public void LinearFractionalFuncException1() {
            thrown.expect(IndexOutOfBoundsException.class);
            Sum functional = new Sum(10, 1);
            fail();
        }
        @Test
        public void LinearFractionalFuncSumException2() {
            thrown.expect(IndexOutOfBoundsException.class);
            Sum functional = new Sum(-1, 10);
            LinearFractionalFunc test = new LinearFractionalFunc(0, 1, 2, 1, 4, 2);
            functional.execute(test);
            fail();
        }

        @Test
        public void ExponentialFuncSumTest(){
            Sum functional=new Sum(-1,1);
            ExponentialFunc test=new ExponentialFunc(-100,100,5,2);
            assertEquals(functional.execute(test),26.430806348152437,0.001);
        }
        @Test
        public void ExponentialFuncSumException1() {
            thrown.expect(IndexOutOfBoundsException.class);
            Sum functional = new Sum(10, 1);
            fail();
        }
        @Test
        public void ExponentialFuncSumException2() {
            thrown.expect(IndexOutOfBoundsException.class);
            Sum functional = new Sum(-1, 1);
            ExponentialFunc test = new ExponentialFunc(-10, 0, 5, 2);
            functional.execute(test);
            fail();
        }
}
