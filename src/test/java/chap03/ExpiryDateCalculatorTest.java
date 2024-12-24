package chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {

    @Test
    void 첫_납부일과_두번쨰_납부일이_다를때_세번쨰_납부일() {
        PayData payData = PayData.builder()
                .firstPayDate(LocalDate.of(2020, 1, 31))
                .payDate(LocalDate.of(2020, 2, 29))
                .payAmount(10_000)
                .build();

        assertExpiryDate(payData, LocalDate.of(2020, 3,31));
    }

    @Test
    void 만원_납부하면_만료일은_한달뒤_같은_일자는_아님() {
        assertExpiryDate(
                PayData.builder()
                        .payDate(LocalDate.of(2020, 1, 31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2020, 2, 29));
        assertExpiryDate(
                PayData.builder()
                        .payDate(LocalDate.of(2020, 5, 31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2020, 6, 30));
        assertExpiryDate(
                PayData.builder()
                        .payDate(LocalDate.of(2020, 1, 31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2020, 2, 29));
    }

    @Test
    void 만원_납부하면_만료일은_한달뒤() {
        assertExpiryDate(
                PayData.builder()
                        .payDate(LocalDate.of(2020, 1, 1))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2020, 2, 1));
    }

    private void assertExpiryDate(PayData payData, LocalDate expect) {
        ExpiryDateCalculater cal = new ExpiryDateCalculater();
        LocalDate realDate = cal.calculateExpiryDate(payData);
        assertEquals(expect, realDate);
    }

}
