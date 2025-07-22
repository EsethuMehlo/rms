package controllers;

import jakarta.validation.Valid;
import models.EmployeeShift;
import models.EmployeeShiftDTO;
import models.Expenses;
import models.ExpensesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import services.EmployeeShiftRepo;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/EmployeeShift")
    public class EmployeeShiftControllers {

    @Autowired
    private EmployeeShiftRepo employeeShiftRepo;
    EmployeeShiftDTO employeeShiftDTO = new EmployeeShiftDTO();

    @GetMapping({"","/"})
    public String showEmployeeShift (Model model){
        List<EmployeeShift> EmployeeShift = employeeShiftRepo.findAll();
        model.addAttribute("EmployeeShift", EmployeeShift);
        return "EmployeeShift/shifts";

    }

    @GetMapping({"","/"})
    public String showExpenses (Model model){
        List<EmployeeShift> EmployeeShifts = employeeShiftRepo.findAll();
        model.addAttribute("EmployeeShifts", EmployeeShifts);
        return "EmployeeShift/shifts";

    }
    @GetMapping("/create")
    public String showCreatePage(Model model){
        EmployeeShiftDTO employeeShiftDTO = new EmployeeShiftDTO();
        model.addAttribute("EmployeeShiftDTO", employeeShiftDTO);
        return "EmployeeShift/createEmployeeShift";
    }

    @PostMapping("/create")
    public String createExpense(@Valid @ModelAttribute EmployeeShiftDTO employeeShiftDTO, BindingResult result){
        if (result.hasErrors()){
            return "EmployeeShift/createEmployeeShift";
        }

        Date date = new Date();
        // Create Shift

        EmployeeShift employeeShift  = new EmployeeShift();

        employeeShift.setStartTime(employeeShiftDTO.getStartTime());
        employeeShift.setEndTime(employeeShiftDTO.getStartTime());


        employeeShiftRepo.save(employeeShift);

        return "redirect:/EmployeeShift";
    }

    @GetMapping ("/edit")
    public String showEditShiftsPage(Model model, @RequestParam int id){

        try{
            EmployeeShift employeeShift = employeeShiftRepo.findById(id).get();
            model.addAttribute("EmployeeShift", employeeShift);

            employeeShift.setStartTime(employeeShiftDTO.getStartTime());
            employeeShift.setEndTime(employeeShiftDTO.getStartTime());


            model.addAttribute("employeeShiftsDTO", employeeShiftDTO);

            return "EmployeeShift/editEmployeeShift";
        }
        catch (Exception ex){
            System.out.println("Exception: " + ex.getMessage());
            return "redirect:/Expenses";

        }

    }

    public String updateEmployeeShifts(Model model, @RequestParam int id, @Valid @ModelAttribute
    EmployeeShiftDTO employeeShiftsDTO, BindingResult result){

        try{
            EmployeeShift employeeShift = employeeShiftRepo.findById(id).get();
            model.addAttribute("EmployeeShifts", employeeShift);

            if (result.hasErrors()){
                return "EmployeeShifts/editEmployeeShift";
            }
            employeeShift.setStartTime(employeeShiftDTO.getStartTime());
            employeeShift.setEndTime(employeeShiftDTO.getStartTime());

            employeeShiftRepo.save(employeeShift);

        }
        catch (Exception ex){
            System.out.println("Exception: " + ex.getMessage());
        }
        return "redirect:/EmployeeShift";
    }

}
