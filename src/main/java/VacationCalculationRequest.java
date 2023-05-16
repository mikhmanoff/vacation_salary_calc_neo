import static com.example.project.imports.*;

public class VacationCalculationRequest implements Serializable {
    private BigDecimal averageSalary;
    private int vacationDays;

    public BigDecimal getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(BigDecimal averageSalary) {
        this.averageSalary = averageSalary;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public BigDecimal calculateVacationAllowance() {
        BigDecimal vacationPay = averageSalary.multiply(BigDecimal.valueOf(vacationDays));
        return vacationPay;
    }
}
