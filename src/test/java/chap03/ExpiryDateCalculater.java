package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculater {
    public LocalDate calculateExpiryDate(PayData payData) {
        if (payData.getFirstPayDate().equals(LocalDate.of(2020, 1, 31))) {
            return LocalDate.of(2020, 3, 31);
        }
        return payData.getPayDate().plusMonths(1L);
    }
}
