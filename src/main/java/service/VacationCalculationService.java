package service;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VacationCalculationService {

    public BigDecimal calculateVacationPay(BigDecimal averageSalary, int vacationDays, LocalDate startDate) {
        BigDecimal vacationPay = averageSalary.multiply(BigDecimal.valueOf(vacationDays));

        if (startDate != null && !startDate.isBefore(LocalDate.now())) {
            long workingDays = calculateWorkingDays(startDate, vacationDays);
            vacationPay = vacationPay.multiply(BigDecimal.valueOf(workingDays));
        }

        return vacationPay;
    }

    private long calculateWorkingDays(LocalDate startDate, int vacationDays) {
        LocalDate endDate = startDate.plusDays(vacationDays);
        long workingDays = 0;
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            if (!isWeekend(currentDate) && !isHoliday(currentDate)) {
                workingDays++;
            }
            currentDate = currentDate.plusDays(1);
        }

        return workingDays;
    }

    private boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    private boolean isHoliday(LocalDate date) {
        int year = date.getYear();
        List<LocalDate> holidays = getOfficialHolidays(year);
        return holidays.contains(date);
    }

    private List<LocalDate> getOfficialHolidays(int year) {
        List<LocalDate> holidays = new ArrayList<>();
        holidays.add(LocalDate.of(year, 1, 1));
        holidays.add(LocalDate.of(year, 1, 2));
        holidays.add(LocalDate.of(year, 1, 3));
        holidays.add(LocalDate.of(year, 1, 4)));
        holidays.add(LocalDate.of(year, 1, 5));
        holidays.add(LocalDate.of(year, 1, 6));
        holidays.add(LocalDate.of(year, 1, 7));
        holidays.add(LocalDate.of(year, 1, 8));
        holidays.add(LocalDate.of(year, 2, 23));
        holidays.add(LocalDate.of(year, 3, 8));
        holidays.add(LocalDate.of(year, 5, 1));
        holidays.add(LocalDate.of(year, 5, 9));
        holidays.add(LocalDate.of(year, 6, 12));
        holidays.add(LocalDate.of(year, 11, 4));

        return holidays;
    }
}
