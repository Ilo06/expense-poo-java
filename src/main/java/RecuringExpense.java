import java.time.LocalDate;

public class RecuringExpense extends Expense{
    Recurence recurence ;

    public Recurence getRecurence() {
        return recurence;
    }

    public void setRecurence(Recurence recurence) {
        this.recurence = recurence;
    }

    public RecuringExpense(String label, double amount, LocalDate date, Recurence recurence) {
        super(label, amount, date);
        recurence = this.getRecurence();
    }

    @Override
    public String toString() {
        return super.toString() + " and the recurence is " + this.getRecurence();
    }
}
