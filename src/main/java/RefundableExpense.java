import java.time.LocalDate;

public class RefundableExpense extends Expense{
    private Boolean refunded;

    public Boolean getRefunded() {
        return refunded;
    }

    public void setRefunded(Boolean refunded) {
        this.refunded = refunded;
    }

    public RefundableExpense(String label, double amount, LocalDate date, Boolean refunded) {
        super(label, amount, date);
        this.refunded = false;
    }

    public Boolean refunded() {
        this.setRefunded(true);
        return this.getRefunded();
    }
}
