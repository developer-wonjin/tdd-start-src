package chap03;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Data
public class PayData {
    private LocalDate firstPayDate;
    private LocalDate payDate;
    private int payAmount;

    private PayData() {}
}
