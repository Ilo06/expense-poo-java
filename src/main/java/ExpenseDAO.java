import java.util.List;
import java.util.stream.Collectors;

public class ExpenseDAO {

    private List<Expense> expenses;

    public ExpenseDAO(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<RefundableExpense> getRefundableExpenses() {
        return expenses.stream()
                .filter(e -> e instanceof RefundableExpense)
                .filter(e -> ((RefundableExpense) e).getRefunded() == false)
                .map(e -> (RefundableExpense) e)
                .collect(Collectors.toList());
    }

    public double getTotalRecurringExpenses() {
        return expenses.stream()
                .filter(e -> e instanceof RecuringExpense)
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public List<String> getLargeExpenseLabels() {
        return expenses.stream()
                .filter(Expense::isLargeExpense)
                .map(Expense::getLabel)
                .collect(Collectors.toList());
    }

    public double getTotalExpense(){
        return  expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }
}
