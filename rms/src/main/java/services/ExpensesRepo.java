package services;

import org.springframework.data.jpa.repository.JpaRepository;

import models.MenuItems;

public interface ExpensesRepo extends JpaRepository<MenuItems, Integer>{

}
