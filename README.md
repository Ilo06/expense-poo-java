

## 📘 Description

This Java project implements a basic **expense management system**, using **object-oriented programming** concepts such as inheritance and encapsulation, as well as **Java Stream API** for data manipulation.

It allows you to model and manage different types of expenses, including refundable and recurring ones, and compute useful analytics like total expenses or filtering large expenses.

---

## 📦 Features

### ✅ 1. Base Class: `Expense`
Represents a standard expense.

- Fields:
  - `String label`
  - `double amount`
  - `LocalDate date`
- Methods:
  - `boolean isLargeExpense()` → returns `true` if amount > 100
  - `String toString()` → clean and readable display of the expense

---

### 🧬 2. Inheritance

#### `RefundableExpense`
- Adds a `boolean refunded` field
- Method:
  - `void refund()` → sets `refunded = true`

#### `RecurringExpense`
- Adds a `Recurence recurrence` field (`monthly` or `yearly`)
- Overrides `toString()` to include the recurrence

---

### 🔁 3. Data Operations with Streams (`ExpenseDAO`)
Implements several utility methods using **Java Stream API**:

- `List<RefundableExpense> getRefundableExpenses()`  
  → Returns only *non-refunded* refundable expenses

- `double getTotalRecurringExpenses()`  
  → Total of all recurring expenses

- `List<String> getLargeExpenseLabels()`  
  → Labels of expenses strictly greater than 100

- `double getTotalExpense()`  
  → Total amount of **all** expenses (including refundable and recurring)

---

### 🧪 4. Unit Tests (JUnit)

Tests include:
- At least one non-refunded `RefundableExpense`
- At least one `RecurringExpense`
- At least one large expense (amount > 100)
- One test per method listed in section 3

---

## 🛠 Technologies Used

- Java 17+
- JUnit 5
- Maven or Gradle (optional for dependency management)
- Git

---


1. Clone the repository:
   ```bash
      https://github.com/Ilo06/expense-poo-java.git   
