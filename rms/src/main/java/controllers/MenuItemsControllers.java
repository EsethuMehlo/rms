package controllers;

import models.MenuItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.MenuItemsRepo;


import java.util.List;

@Controller
@RequestMapping("/menuitems")

public class MenuItemsControllers {

    @Autowired
    private MenuItemsRepo menuitemsRepo;

    @GetMapping({"","/"})
    public String showMenuItems (Model model){
        List<MenuItems> menuitems = menuitemsRepo.findAll();
        model.addAttribute("menuItem", menuitems);
        return "menuItems/index";

    }
}
