package chap02;

//import org.junit.platform.commons.util.StringUtils;

public class PasswordStrengthMeter {

    public PasswordStrengthEnum meter(String s) {
        if (isNullorBlank(s)) return PasswordStrengthEnum.INVALID;

        int meetCount = getMeetCount(s);
        if (meetCount <= 1) return PasswordStrengthEnum.WEAK;
        if (meetCount == 2) return PasswordStrengthEnum.NORMAL;
        return PasswordStrengthEnum.STRONG;
    }

    private boolean isNullorBlank(String s) {
        return s == null || s.isBlank();
    }

    private int getMeetCount(String s) {
        int meetCount = 0;
        if (s.length() >= 8) meetCount++;
        if (containNums(s)) meetCount++;
        if (containUpper(s)) meetCount++;
        return meetCount;
    }

    private static boolean containUpper(String s) {
        return s.matches(".*[A-Z].*");
    }

    private boolean containNums(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }
}

