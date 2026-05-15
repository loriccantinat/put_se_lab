package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    @Test
    void loadExpenses() {

//        ExpenseRepository expenseRepository = new ExpenseRepository();
//        expenseRepository.loadExpenses();
//        assertTrue(expenseRepository.getExpenses().isEmpty());
//        IFancyDatabase mockDatabase = new MyDatabase();
//        ExpenseRepository expenseRepository = new ExpenseRepository(mockDatabase);
//        expenseRepository.loadExpenses();
//        assertTrue(expenseRepository.getExpenses().isEmpty(), "List should be empty");

        IFancyDatabase mockDatabase = mock(IFancyDatabase.class);

        when(mockDatabase.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository expenseRepository = new ExpenseRepository(mockDatabase);
        expenseRepository.loadExpenses();

        InOrder inOrder = inOrder(mockDatabase);

        inOrder.verify(mockDatabase).connect();
        inOrder.verify(mockDatabase).queryAll();
        inOrder.verify(mockDatabase).close();

        assertTrue(expenseRepository.getExpenses().isEmpty(), "List should be empty");

    }

    @Test
    void saveExpenses() {
        IFancyDatabase mockDatabase = mock(IFancyDatabase.class);
        ExpenseRepository expenseRepository = new ExpenseRepository(mockDatabase);

//        expenseRepository.addExpense(new Expense());
//        expenseRepository.saveExpenses();
        for (int i = 0; i < 5; i++) {
            expenseRepository.addExpense(new Expense());
        }
        expenseRepository.saveExpenses();

        InOrder inOrder = inOrder(mockDatabase);
        inOrder.verify(mockDatabase).connect();
        inOrder.verify(mockDatabase, times(5)).persist(any(Expense.class));
        inOrder.verify(mockDatabase).close();
    }
}
