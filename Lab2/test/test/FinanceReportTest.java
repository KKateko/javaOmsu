package test;

import imit.student.classes.Payment;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import imit.student.classes.FinanceReport;

import java.io.IOException;
import java.util.ArrayList;

import static imit.student.classes.FinanceReport.FileInput;
import static imit.student.classes.FinanceReport.FileOutput;
import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertEquals;

public class FinanceReportTest {
    @DataProvider
    public static Object[][] dataFinanceReportCopy() {
        Payment []array=new Payment[2];
        array[0]=new Payment("Donald Duck",13,12,11,1234);
        array[1]=new Payment("Mickey Mouse",23,8,20,3455);
        FinanceReport one=new FinanceReport(array);
        FinanceReport two=new FinanceReport(one);
        return new Object[][]{
                {one,two}
        };
    }
    @DataProvider
    public static Object[][] dataLetterParameter() {
        Payment []array=new Payment[3];
        array[0]=new Payment("Donald Duck",13,12,11,1234);
        array[1]=new Payment("Mickey Mouse",23,8,20,3455);
        array[2]=new Payment("Mini Mouse",5,4,12,455);
        FinanceReport one= new FinanceReport(array);
        ArrayList actual=new ArrayList();
        ArrayList actual1=new ArrayList();
        actual.add(array[1].toString());
        actual.add(array[2].toString());
    return new Object[][]{
            {one,'M',actual},
            {one,'N',actual1}
    };
}

    @DataProvider
    public static Object[][] dataSizeParameter() {
        Payment []array=new Payment[3];
        array[0]=new Payment("Donald Duck",13,12,11,1234);
        array[1]=new Payment("Mickey Mouse",23,8,20,3455);
        array[2]=new Payment("Mini Mouse",5,4,12,455);
        FinanceReport one= new FinanceReport(array);
        ArrayList actual=new ArrayList();
        ArrayList actual1=new ArrayList();
        actual.add(array[0].toString());
        actual.add(array[2].toString());
        return new Object[][]{
                {one,3000,actual},
                {one,400,actual1}
        };
    }

    @DataProvider
    public static Object[][] dataTotalPayment() {
        Payment []array=new Payment[4];
        array[0]=new Payment("Donald Duck",6,9,12,1234);
        array[1]=new Payment("Mickey Mouse",23,8,20,3455);
        array[2]=new Payment("Mini Mouse",6,9,12,455);
        array[3]=new Payment("Goofy",6,9,12,879);
        FinanceReport one= new FinanceReport(array);
        return new Object[][]{
                {one,"06.09.12",2568},
                {one,"23.08.20",3455},
                {one,"12.12.12",0}

        };
    }

    @DataProvider
    public static Object[][] dataListMonth() {
        Payment[] array = new Payment[4];
        array[0] = new Payment("Donald Duck", 12, 7, 20, 1234);
        array[1] = new Payment("Mickey Mouse", 23, 8, 20, 3455);
        array[2] = new Payment("Mini Mouse", 6, 9, 20, 455);
        array[3] = new Payment("Goofy", 7, 5, 20, 879);
        FinanceReport one = new FinanceReport(array);
        ArrayList actual1 = new ArrayList();
        actual1.add("Январь");
        actual1.add("Февраль");
        actual1.add("Март");
        actual1.add("Апрель");
        actual1.add("Июнь");
        actual1.add("Октябрь");
        actual1.add("Ноябрь");
        actual1.add("Декабрь");
        return new Object[][]{
                {one,20,actual1},
        };
    }

    @DataProvider
    public static Object[][] dataNumberOfPayment() {
        Payment []array=new Payment[4];
        array[0]=new Payment("Donald Duck",6,9,12,1234);
        array[1]=new Payment("Mickey Mouse",23,8,20,3455);
        array[2]=new Payment("Mini Mouse",6,9,12,455);
        array[3]=new Payment("Goofy",6,9,12,879);
        FinanceReport one= new FinanceReport(array);
        return new Object[][]{
                {one,4}
        };
    }

    @DataProvider
    public static Object[][] dataWriteThePayment() {
        Payment []array=new Payment[3];
        array[0]=new Payment("Donald Duck",6,9,12,1234);
        array[1]=new Payment("Mickey Mouse",23,8,20,3455);
        array[2]=new Payment("Mini Mouse",6,9,12,455);
        FinanceReport one= new FinanceReport(array);
        Payment actual=new Payment("Gooofy",12,2,34,4567);
        return new Object[][]{
                {2,one,"Gooofy",12,2,34,4567,actual}
        };
    }

    @DataProvider
    public static Object[][] dataFileInput() {
        Payment []array=new Payment[2];
        array[0]=new Payment("Mini Mouse",29,9,17,1455);
        array[1]=new Payment("Mouse Mou",12,12,15,455);
        FinanceReport actual= new FinanceReport(array);
        return new Object[][]{
                {"Test.txt",actual}
        };
    }

    @DataProvider
    public static Object[][] dataFileOutput() {
        Payment []array=new Payment[3];
        array[0]=new Payment("Donald Duck",6,9,12,1234);
        array[1]=new Payment("Mickey Mouse",23,8,20,3455);
        array[2]=new Payment("Mini Mouse",6,9,12,455);
        FinanceReport one= new FinanceReport(array);
        return new Object[][]{
                {"TestOut.txt",one.listOfMonth(12).toString()},
                {"TestOut.txt",one.toString()}
        };
    }

    @Test (dataProvider = "dataWriteThePayment")
    public  void writeThePaymentTest(int i,FinanceReport one,String FIO,int day,int month,int year,int amoutOfPayment,Payment actual){
        one.writeThePayment(i,FIO,day,month,year,amoutOfPayment);
        assertEquals(one.get(i),actual);
    }
    @Test (dataProvider = "dataNumberOfPayment")
    public void numberOfPaymentTest(FinanceReport one,int actual){
        assertEquals(one.NumberOfPayments(),actual);

    }
    @Test(dataProvider = "dataFinanceReportCopy")
    public void FinanceReportCopyTest(FinanceReport one,FinanceReport two){
        Assert.assertEquals(one,two);
    }
    @Test(dataProvider = "dataLetterParameter")
   public void outputWithLetterParameterTest(FinanceReport one,char letterParameter,ArrayList actual){
        assertEquals(one.outputWithLetterParameter(letterParameter),actual);
    }
    @Test (dataProvider = "dataSizeParameter")
    public void outputWithSizeParameterTest(FinanceReport one,int sizeParameter,ArrayList actual){
        assertEquals(one.outputWithSizeParameter(sizeParameter),actual);
    }
    @Test (dataProvider = "dataTotalPayment")
    public void totalPaymentTest(FinanceReport one,String date,int actual){
        assertEquals(one.totalPayment(date),actual);
    }
    @Test(expectedExceptions = Exception.class)
    public void totalPaymentExceptionTest(){
        Payment []array=new Payment[1];
        array[0]=new Payment("Donald Duck",6,9,12,1234);
        FinanceReport one= new FinanceReport(array);
        one.totalPayment("45.09.123");
        fail();
    }
    @Test(dataProvider = "dataListMonth")
    public void listOfMonthTest(FinanceReport one,int year,ArrayList actual){
        assertEquals(one.listOfMonth(year),actual);
    }
    @Test(dataProvider = "dataFileInput")
    public void FileInputTest(String nameFile,FinanceReport actual) throws IOException {

        assertEquals(FileInput(nameFile),actual);

    }
    @Test(dataProvider = "dataFileOutput")
    public void FileOutputTest(String nameFile,String out) throws IOException {
        FileOutput(nameFile,out);

    }
}
