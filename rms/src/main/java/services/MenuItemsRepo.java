package services;

import org.springframework.data.jpa.repository.JpaRepository;

import models.MenuItems;

public interface MenuItemsRepo  extends JpaRepository<MenuItems, Integer>{

}
