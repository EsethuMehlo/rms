package controllers;

import jakarta.validation.Valid;
import models.Expenses;
import models.ExpensesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import services.ExpensesRepo;


import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Expenses")

public class ExpensesControllers {

    ExpensesDTO expenseDTO = new ExpensesDTO();

    @Autowired
    private ExpensesRepo ExpensesRepo;

    @GetMapping({"","/"})
    public String showExpenses (Model model){
        List<Expenses> Expenses = ExpensesRepo.findAll();
        model.addAttribute("Expenses", Expenses);
        return "Expenses/index";

    }
    @GetMapping("/create")
    public String showCreatePage(Model model){
        ExpensesDTO expensesDTO = new ExpensesDTO();
        model.addAttribute("ExpensesDTO", expensesDTO);
        return "Expenses/createExpense";
    }

    @PostMapping ("/create")
    public String createExpense(@Valid @ModelAttribute ExpensesDTO expensesDTO, BindingResult result){
        if (result.hasErrors()){
            return "Expenses/createExpense";
        }

        Date date = new Date();
        // Create Expense

        Expenses Expense = new Expenses();
        Expense.setExpenseName(expensesDTO.getExpenseName());
        Expense.setExpenseDate(date.toString());
        Expense.setExpenseAmount(expensesDTO.getExpenseAmount());

        ExpensesRepo.save(Expense);

        return "redirect:/Expenses";
    }

    @GetMapping ("/edit")
    public String showEditPage(Model model, @RequestParam int id){

        try{
            Expenses Expense = ExpensesRepo.findById(id).get();
            model.addAttribute("Expense", Expense);

            Date date = new Date();

            Expense.setExpenseName(expenseDTO.getExpenseName());
            Expense.setExpenseDate(date.toString());
            Expense.setExpenseAmount(expenseDTO.getExpenseAmount());

            model.addAttribute("expenseDTO", expenseDTO);

            return "Expenses/editExpense";
        }
        catch (Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return "redirect:/Expenses";

        }

    }

    public String updateExpense(Model model, @RequestParam int id, @Valid @ModelAttribute
    ExpensesDTO expenseDTO, BindingResult result){

        try{
            Expenses Expense = ExpensesRepo.findById(id).get();
            model.addAttribute("Expense", Expense);

            if (result.hasErrors()){
                return "Expenses/editExpense";
            }
            Expense.setExpenseName(expenseDTO.getExpenseName());
            Expense.setExpenseAmount(expenseDTO.getExpenseAmount());

            ExpensesRepo.save(Expense);

        }
        catch (Exception ex){
            System.out.println("Exception: " + ex.getMessage());
        }
        return "redirect:/Expenses";
    }

}
