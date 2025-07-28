import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTest {

    private ExpenseDAO myExpenses;
    private RefundableExpense phone;

    @BeforeEach
    public void setUp() {
        Expense food = new Expense("food", 10.0, null);
        Expense transport = new Expense("transport", 100.0, null);
        Expense houseRent = new Expense("house", 1000.0, null);
        phone = new RefundableExpense("phone", 1000.0, null, false);
        RecuringExpense monthlyCarInsurance = new RecuringExpense("car insurance", 100.0, null, Recurence.monthly);
        RecuringExpense yearlyCarInsurance = new RecuringExpense("car insurance", 100.0, null, Recurence.yearly);

        List<Expense> expenses = new ArrayList<>();
        expenses.add(food);
        expenses.add(transport);
        expenses.add(houseRent);
        expenses.add(phone);
        expenses.add(monthlyCarInsurance);
        expenses.add(yearlyCarInsurance);

        myExpenses = new ExpenseDAO(expenses);
    }

    @Test
    public void testGetRefundableExpenses() {
        List<RefundableExpense> expected = List.of(phone);
        List<RefundableExpense> actual = myExpenses.getRefundableExpenses();

        Assertions.assertEquals(expected, actual, "Refundable expenses should match expected list");
        Assertions.assertEquals(1, actual.size(), "There should be exactly one refundable expense");
    }

    @Test
    public void testGetTotalRecurringExpenses() {
        double expected = 200.0;
        double actual = myExpenses.getTotalRecurringExpenses();

        Assertions.assertEquals(expected, actual, 0.001, "Total recurring expenses should be 200.0");
    }

    @Test
    public void testGetLargeExpenseLabels() {
        List<String> expected = List.of("house", "phone");
        List<String> actual = myExpenses.getLargeExpenseLabels();

        Assertions.assertEquals(expected, actual, "Large expense labels should be ['house', 'phone']");
    }

    @Test
    public void testGetTotalExpense() {
        double expected = 2310.0; // sum of all expenses
        double actual = myExpenses.getTotalExpense();

        Assertions.assertEquals(expected, actual, 0.001, "Total expense should be 2310.0");
    }
}
