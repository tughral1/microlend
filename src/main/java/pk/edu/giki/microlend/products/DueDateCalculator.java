package pk.edu.giki.microlend.products;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 * Generates monthly instalment dates based on the original
 * loan disbursement day, handling months with fewer days.
 */
public class DueDateCalculator {

    /**
     * Generates monthly due dates for the requested loan tenure.
     *
     * @param disbursementDate date the loan was disbursed
     * @param tenureMonths number of monthly instalments
     * @return list of monthly due dates in chronological order
     */
    public List<LocalDate> dueDates(
            LocalDate disbursementDate, int tenureMonths) {

        if (disbursementDate == null) {
            throw new IllegalArgumentException(
                    "Disbursement date cannot be null");
        }

        if (tenureMonths < 1) {
            throw new IllegalArgumentException(
                    "Tenure must be at least one month");
        }

        List<LocalDate> dates = new ArrayList<>();
        int originalDay = disbursementDate.getDayOfMonth();

        for (int month = 1; month <= tenureMonths; month++) {
            YearMonth targetMonth = YearMonth.from(disbursementDate)
                    .plusMonths(month);

            int dueDay = Math.min(
                    originalDay, targetMonth.lengthOfMonth());

            dates.add(targetMonth.atDay(dueDay));
        }

        return List.copyOf(dates);
    }

}
