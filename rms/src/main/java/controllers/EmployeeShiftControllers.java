package controllers;

import models.EmployeeShift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.EmployeeShiftRepo;

import java.util.List;

@Controller
@RequestMapping("/EmployeeShift")public class EmployeeShiftControllers {
    @Autowired
    private EmployeeShiftRepo EmployeeShiftRepo;

    @GetMapping({"","/"})
    public String showEmployeeShift (Model model){
        List<EmployeeShift> EmployeeShift = EmployeeShiftRepo.findAll();
        model.addAttribute("EmployeeShift", EmployeeShift);
        return "EmployeeShift/index";

    }
}
