import static com.project.imports.*;


public class VacationCalculationResponse implements Serializable {
    private BigDecimal vacationPay;

    public BigDecimal getVacationPay() {
        return vacationPay;
    }

    public void setVacationPay(BigDecimal vacationPay) {
        this.vacationPay = vacationPay;
    }
}