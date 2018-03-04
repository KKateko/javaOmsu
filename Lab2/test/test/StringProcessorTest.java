package  test;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static imit.student.classes.StringProcessor.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StringProcessorTest {


    @DataProvider(name = "copyString")
    public static Object[][] data() {
        return new Object[][]{
                {"катя", 3, "катякатякатя"},
                {"",3, ""},
                {"Q", 4, "QQQQ"},
                {"",0,""},
                {"катя",0,""}
        };
    }
    @DataProvider
    public static Object[][] dataTwoStr() {
        return new Object[][]{
                {"venitestvicitestvidi","test",2},
                {"venivicividi","test",0},
                {"","test",0},
                {"aa","a",2},
                {"","",1},
                {"aaa","aa",2},
                {"venivicividi","",0},

        };
    }
    @DataProvider
    public static Object[][] dataNewFromOld() {
        return new Object[][]{
                {"1,2,3,4,5 вышел зайчик погулять","один,два,три,4,5 вышел зайчик погулять"},
                {"          1           ","          один           "},
                {"  катя 1","  катя один"},
                {"",""},
                {" катюша катюша"," катюша катюша"}
        };
    }
    @DataProvider
    public static Object[][] dataModification() {
        return new Object[][]{
                {new StringBuilder("123456789"),new StringBuilder("13579")},
                {new StringBuilder("13579"),new StringBuilder("159")},
                {new StringBuilder("159"),new StringBuilder("19")},
                {new StringBuilder("19"),new StringBuilder("1")},
                {new StringBuilder("1"),new StringBuilder("1")},
        };
    }
    @DataProvider
    public static Object[][] dataSwap() {
        return new Object[][]{
                {new StringBuilder("  Best The IMIT  "),"  IMIT The Best  "},
                {new StringBuilder(""),""},
                {new StringBuilder(" I am a kitty.")," kitty. am a I"},
                {new StringBuilder(" катя  ")," катя  "}

        };
    }
    @DataProvider
    public static Object[][] dataHexToDec() {
        return new Object[][]{
                {new StringBuilder("Васе 0x00000010 лет"),"Васе 16 лет"},
                {new StringBuilder(""),""},
                {new StringBuilder("Васе 10 лет"),"Васе 10 лет"},
                {new StringBuilder("Васе x лет"),"Васе x лет"},
                {new StringBuilder("0x0000EF00 зайки"),"61184 зайка"}
        };
    }
    @Test(dataProvider = "copyString")
    public void copyOfStringTest(String string, int N, String actual){
        assertEquals(copyOfString(string, N), actual);
    }
    @Test(expectedExceptions = Exception.class)
    public void testCopyException(){
        copyOfString("NN", -2);
        fail();
    }
    @Test(dataProvider = "dataTwoStr")
    public void countOfEntriesTest(String one, String two, int actual){
        assertEquals(countOfEntries(one,two),actual);
    }
    @Test(dataProvider = "dataNewFromOld")
    public void newStringFromOldTest(String str,String actual){
        assertEquals(newStringFromOld(str),actual);
    }
    @Test(dataProvider = "dataModification")
    public void modificationStrTest(StringBuilder str,StringBuilder actual){
        modificationStr(str);
        assertEquals(str.toString(),actual.toString());
    }
    @Test(dataProvider = "dataSwap")
    public void swapStrTest(StringBuilder str,String actual){
        swapStr(str);
        assertEquals(str.toString(),actual);

    }
    @Test(dataProvider = "dataHexToDec")
    public void hextoDecTest(StringBuilder str, String actual){

        assertEquals(hexToDec(str).toString(),actual);

    }
}
