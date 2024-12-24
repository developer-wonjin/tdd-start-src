package chap02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {

    PasswordStrengthMeter meter = new PasswordStrengthMeter();

    @Test
    void 입력암호가_BLANK_유효하지않음() {
        assertStrength(null, PasswordStrengthEnum.INVALID);
        assertStrength("", PasswordStrengthEnum.INVALID);
    }

    @Test
    void 모두_만족안함_약함() {
        assertStrength("aa", PasswordStrengthEnum.WEAK);
    }

    @Test
    void 다_만족_약함() {
        assertStrength("AA", PasswordStrengthEnum.WEAK);
    }

    @Test
    void 나_만족_약함() {
        assertStrength("00", PasswordStrengthEnum.WEAK);
    }

    @Test
    void 가_만족_약함() {
        assertStrength("aaaaaaaa", PasswordStrengthEnum.WEAK);
    }    
    
    @Test
    void 가나_두개만족_보통() {
        assertStrength("a12!@abc", PasswordStrengthEnum.NORMAL);
    }

    @Test
    void 가다_두개만족_보통() {
        assertStrength("abc!@ABC", PasswordStrengthEnum.NORMAL);
    }

    @Test
    void 나다_두개만족_보통() {
        assertStrength("b12!@AB", PasswordStrengthEnum.NORMAL);
    }

    @Test
    void 가나다_모두만족_강함() {
        assertStrength("ab12!@AB", PasswordStrengthEnum.STRONG);
        assertStrength("ab12!@ADD", PasswordStrengthEnum.STRONG);
    }

    private void assertStrength (String password, PasswordStrengthEnum expect) {
        Assertions.assertEquals(expect, meter.meter(password));
    }

}
