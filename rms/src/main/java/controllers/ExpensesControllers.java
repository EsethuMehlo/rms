package controllers;

import models.Expenses;
import models.ExpensesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.ExpensesRepo;


import java.util.List;

@Controller
@RequestMapping("/Expenses")

public class ExpensesControllers {

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
}
