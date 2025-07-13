package services;
import models.EmployeeShift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeShiftRepo extends JpaRepository<EmployeeShift, Integer>{
}
