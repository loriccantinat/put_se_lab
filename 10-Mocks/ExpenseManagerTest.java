package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import put.io.students.fancylibrary.service.FancyService;

public class ExpenseManagerTest {

    @Test
    void calculateTotal() {
        IExpenseRepository mockRepo = mock(IExpenseRepository.class);
        FancyService mockService = mock(FancyService.class);
        List<Expense> mockExpenses = new ArrayList<>();

        Expense e1 = new Expense();
        e1.setAmount(1);
        Expense e2 = new Expense();
        e2.setAmount(2);
        Expense e3 = new Expense();
        e3.setAmount(3);
        mockExpenses.add(e1);
        mockExpenses.add(e2);
        mockExpenses.add(e3);

        when(mockRepo.getExpenses()).thenReturn(mockExpenses);

        ExpenseManager manager = new ExpenseManager(mockRepo, mockService);
        long result = manager.calculateTotal();

        assertEquals(6, result);
    }

    @Test
    void calculateTotalForCategory() {
        IExpenseRepository mockRepo = mock(IExpenseRepository.class);
        FancyService mockService = mock(FancyService.class);
        ExpenseManager manager = new ExpenseManager(mockRepo, mockService);

        //home expenses
        List<Expense> homeExpenses = new ArrayList<>();
        Expense e1 = new Expense();
        e1.setAmount(1);
        homeExpenses.add(e1);


        //car expenses
        List<Expense> carExpenses = new ArrayList<>();
        Expense e2 = new Expense();
        e2.setAmount(2);
        carExpenses.add(e2);

        //food expenses
        List<Expense> foodExpenses = new ArrayList<>();
        Expense e3 = new Expense();
        e3.setAmount(3);
        foodExpenses.add(e3);

        //for other string than home, car and food
        when(mockRepo.getExpensesByCategory(anyString())).thenReturn(Collections.emptyList());

        //for home, car and food
        when(mockRepo.getExpensesByCategory("Home")).thenReturn(homeExpenses);
        when(mockRepo.getExpensesByCategory("Car")).thenReturn(carExpenses);
        when(mockRepo.getExpensesByCategory("Food")).thenReturn(foodExpenses);


        assertEquals(1, manager.calculateTotalForCategory("Home"));
        assertEquals(2, manager.calculateTotalForCategory("Car"));
        assertEquals(3, manager.calculateTotalForCategory("Food"));
        assertEquals(0, manager.calculateTotalForCategory("Sport"));

    }

    @Test
    void calculateTotalInDollars() throws ConnectException {
        IExpenseRepository mockRepo = mock(IExpenseRepository.class);
        //FancyService realService = new FancyService();
        FancyService mockService = mock(FancyService.class);
        ExpenseManager manager = new ExpenseManager(mockRepo, mockService);

        Expense e1 = new Expense();
        e1.setAmount(100);
        when(mockRepo.getExpenses()).thenReturn(Collections.singletonList(e1));
        //mocking service by assuming that 1$=4PLN so 100PLN=25$
        //when(mockService.convert(anyDouble(), eq("PLN"), eq("USD"))).thenReturn(25.0);

        //mocking assuming it generate and exception
        //when(mockService.convert(anyDouble(), eq("PLN"), eq("USD"))).thenThrow(new ConnectException());

        //mocking with dynamic calcul
        when(mockService.convert(anyDouble(), eq("PLN"), eq("USD")))
                .thenAnswer(invocation -> {
                    Double amount = invocation.getArgument(0); //get the first argument
                    return amount / 4.0; //divide by 4 to make the calcul
                });
        long result = manager.calculateTotalInDollars();

        assertEquals(25,result);
        //assertEquals(-1, result);
    }
}
