package pk.edu.giki.microlend.products;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

class DueDateCalculatorTest {

    private final DueDateCalculator calculator =
            new DueDateCalculator();

    @Test
    void calculatesMonthlyDueDatesCorrectly() {
        List<LocalDate> actual = calculator.dueDates(
                LocalDate.of(2025, 1, 31), 4);

        List<LocalDate> expected = List.of(
                LocalDate.of(2025, 2, 28),
                LocalDate.of(2025, 3, 31),
                LocalDate.of(2025, 4, 30),
                LocalDate.of(2025, 5, 31));

        assertEquals(expected, actual);
    }

    @Test
    void generatesRequestedNumberOfDates() {
        List<LocalDate> actual = calculator.dueDates(
                LocalDate.of(2025, 6, 15), 6);

        assertEquals(6, actual.size());
    }
}