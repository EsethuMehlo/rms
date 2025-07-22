package models;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

public class EmployeeShiftDTO {

    @Min(0)
    private int expenseId;

    @NotNull(message = "Date must not be null")
    @PastOrPresent(message = "Today's date not a future date.")
    private LocalDateTime dateNow;

    @NotNull (message = "Shift start date cannot be null")
    private LocalDateTime startTime;

    @NotNull (message = "Shift end date cannot be null")
    private LocalDateTime endTime;

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
