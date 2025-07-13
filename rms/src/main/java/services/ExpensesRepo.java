package services;

import models.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

import models.Expenses;

public interface ExpensesRepo extends JpaRepository<Expenses, Integer>{

}
