package imit.student.classes;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class FinanceReport {
    private Payment [] arrayOfPayment;

    public FinanceReport(Payment[] arrayOfPayment) {
        this.arrayOfPayment=arrayOfPayment;
    }

    public FinanceReport(FinanceReport report) {
        this.arrayOfPayment=report.arrayOfPayment;
    }

    public Payment get(int i) throws ArrayIndexOutOfBoundsException {
        return arrayOfPayment[i];
    }

    public void set(int i, Payment payment) {
        arrayOfPayment[i]=payment;
    }

    public static boolean checkDate(int day,int month,int year) {
        int [] days={31,28,31,30,31,30,31,31,30,31,30,31};
        if(month<0 || month>12 ||day<0 ||year <0) return false;
        if(month!=2 && day>days[month-1]) return false;
        if(month==2 && ((year%400==0 && day>29)||(year%400!=0 && day>28))) return false;
        return true;
    }

    public void inputThePayment(){
        Scanner scan=new Scanner(System.in);
        String FIO;
        int end=0;
        int day=0,month=1,year=0;
        int N,amountOfPayment;
        System.out.println("Введите количество платежей:");
        N=scan.nextInt();
        arrayOfPayment=new Payment[N];
        for(int i=0;i<N;i++) {
            do {

                System.out.println(i + 1 + ")");
                System.out.println("Введите ФИО:");
                scan.nextLine();
                FIO = scan.nextLine();
                System.out.println("Введите дату:");
                day=scan.nextInt();
                month=scan.nextInt();
                year=scan.nextInt();
                System.out.println("Введите величину платежа:");
                amountOfPayment = scan.nextInt();
                if(!checkDate(day,month,year)){
                    System.out.println("Некорректные данные.Повторите попытку");
                }else{
                    end=1;
                arrayOfPayment[i] = new Payment(FIO, day, month, year, amountOfPayment);
                }
            }while (end==0);
        }
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (Payment payment : arrayOfPayment) {
             builder.append(String.format("Плательщик: %s\r\n Дата: %d.%d.%d\r\n Сумма:%d \r\n",
                    payment.getFIO(),payment.getDay(),payment.getMonth(), payment.getYear(),payment.getAmountOfPayment()
            ));
        }
        return  builder.toString();
    }

    public int NumberOfPayments(){
        return arrayOfPayment.length;
    }

    public String readThePayment(int i){
        return arrayOfPayment[i].toString();
    }

    public void writeThePayment(int i,String FIO,int day,int month,int year,int amountOfPayment)throws IllegalArgumentException{
        if(checkDate(day,month,year)){
        arrayOfPayment[i].setFIO(FIO);
        arrayOfPayment[i].setDay(day);
        arrayOfPayment[i].setMonth(month);
        arrayOfPayment[i].setYear(year);
        arrayOfPayment[i].setAmountOfPayment(amountOfPayment);
        }
        else throw new IllegalArgumentException();
    }

    //вывод в поток информации о платежах всех людей, чья фамилия нач-ся на указ-й символ
    public ArrayList outputWithLetterParameter(char parameter){
        ArrayList answer=new ArrayList();
        for(int i=0;i<arrayOfPayment.length;i++){
            if(arrayOfPayment[i].getFIO().charAt(0)==parameter){
                answer.add(readThePayment(i));
            }
        }
        return answer;
    }

    //вывод всех платежей, размер которых меньше заданной величины
    public ArrayList outputWithSizeParameter(int value){
        ArrayList answer=new ArrayList();
        for(int i=0;i<arrayOfPayment.length;i++){
            if(arrayOfPayment[i].getAmountOfPayment()<value){
               answer.add(readThePayment(i));
            }
        }
        return answer;
    }

   //вычислите суммарный платеж на конкретную дату
    public int totalPayment(String date)throws IllegalArgumentException {
        int total = 0;
        int day, month, year;
        if (date.substring(0, 1) == "0") {
            day = Integer.parseInt(date.substring(1, 2));
        } else {
            day = Integer.parseInt(date.substring(0, 2));
        }
        if (date.substring(3, 4) == "0") {
            month = Integer.parseInt(date.substring(4, 5));
        } else {
            month = Integer.parseInt(date.substring(3, 5));
        }
        if (date.substring(6, 7) == "0") {
            year = Integer.parseInt(date.substring(7, 8));
        } else {
            year = Integer.parseInt(date.substring(6, 8));
        }
        if(!checkDate(day,month,year)){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < arrayOfPayment.length; i++) {
            if (arrayOfPayment[i].getDay() == day && arrayOfPayment[i].getMonth() == month && arrayOfPayment[i].getYear() == year) {
                total += arrayOfPayment[i].getAmountOfPayment();
            }
        }
        return total;
    }

    public ArrayList listOfMonth(int year){
        ArrayList answer=new ArrayList();
        String [] flags={"Январь","Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"};
        for(int i=0;i<arrayOfPayment.length;i++){
            if(arrayOfPayment[i].getYear()==year){
                flags[arrayOfPayment[i].getMonth()-1]="";
            }
        }
        for(int i=0;i<12;i++){
            if(flags[i]!=""){
                answer.add(flags[i]);
            }
        }
        return answer;
    }

    public static FinanceReport FileInput(String nameFile) throws IllegalArgumentException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(nameFile)));
        String FIO="";
        String date="";
        int N;
        int pay=0;
        int day, month, year;
        if(reader.ready())N= Integer.parseInt(reader.readLine());
        else throw new IOException();
        Payment[] payments =new Payment[N];

        for(int i=0;i<N;i++) {
            if (!reader.ready()) throw new IOException();
            FIO = reader.readLine();
            System.out.println(FIO);
            if (!reader.ready()) throw new IOException();
            date = reader.readLine();
            System.out.println(date);
            if (!reader.ready()) throw new IOException();
            pay = Integer.parseInt(reader.readLine());
            System.out.println(pay);

            if (date.substring(0, 1) == "0") {
                day = Integer.parseInt(date.substring(1, 2));
            } else {
                day = Integer.parseInt(date.substring(0, 2));
            }
            if (date.substring(3, 4) == "0") {
                month = Integer.parseInt(date.substring(4, 5));
            } else {
                month = Integer.parseInt(date.substring(3, 5));
            }
            if (date.substring(6, 7) == "0") {
                year = Integer.parseInt(date.substring(7, 8));
            } else {
                year = Integer.parseInt(date.substring(6, 8));
            }
            if (!checkDate(day, month, year)) {
                throw new IllegalArgumentException();
            }
            payments[i] = new Payment(FIO, day, month, year, pay);
        }
        FinanceReport report=new FinanceReport(payments);
        reader.close();
        return report;

    }
    public static void FileOutput(String nameFile,String out) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile,true))) {
            writer.write("\r\r\n");
            writer.write(out);
            writer.write("\r\r\n");
            writer.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinanceReport)) return false;

        FinanceReport that = (FinanceReport) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(arrayOfPayment, that.arrayOfPayment);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arrayOfPayment);
    }
}
