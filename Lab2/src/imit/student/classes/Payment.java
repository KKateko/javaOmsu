package imit.student.classes;

public class Payment {
    private String FIO;
    private int day,month,year;
    private int amountOfPayment;

    public Payment(String FIO, int day, int month, int year, int amountOfPayment) {
        this.FIO = FIO;
        this.day = day;
        this.month = month;
        this.year = year;
        this.amountOfPayment = amountOfPayment;
    }
    public Payment(Payment p) {
        this.FIO=p.FIO;
        this.day = p.day;
        this.month = p.month;
        this.year = p.year;
        this.amountOfPayment = p.amountOfPayment;
    }

    public String getFIO() {
        return FIO;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getAmountOfPayment() {
        return amountOfPayment;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAmountOfPayment(int amountOfPayment) {
        this.amountOfPayment = amountOfPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (getDay() != payment.getDay()) return false;
        if (getMonth() != payment.getMonth()) return false;
        if (getYear() != payment.getYear()) return false;
        if (getAmountOfPayment() != payment.getAmountOfPayment()) return false;
        return getFIO() != null ? getFIO().equals(payment.getFIO()) : payment.getFIO() == null;
    }

    @Override
    public int hashCode() {
        int result = getFIO() != null ? getFIO().hashCode() : 0;
        result = 31 * result + getDay();
        result = 31 * result + getMonth();
        result = 31 * result + getYear();
        result = 31 * result + getAmountOfPayment();
        return result;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "FIO='" + FIO + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", amountOfPayment=" + amountOfPayment +
                '}';
    }
}
