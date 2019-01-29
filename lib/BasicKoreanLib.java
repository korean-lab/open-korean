public class BasicKoreanLib {
    public final static String buildEunJosa(String targetStr) throws IllegalArgumentException {
        String josa = "";
        char lastChar = targetStr.charAt(targetStr.length() - 1);
        
        if (lastChar < 0xAC00 || lastChar > 0xD7A3) {
            throw new IllegalArgumentException("It's not Korean Alphabet. Out of range.");
        }
        
        josa = (lastName - 0xAC00) % 28 > 0 ? "은" : "는";

        return targetStr+josa;
    }
    
    public final static String buildGaJosa(String targetStr) throws IllegalArgumentException {
        String josa = "";
        char lastChar = targetStr.charAt(targetStr.length() - 1);
        
        if (lastChar < 0xAC00 || lastChar > 0xD7A3) {
            throw new IllegalArgumentException("It's not Korean Alphabet. Out of range.");
        }
        
        josa = (lastName - 0xAC00) % 28 > 0 ? "이가" : "가";

        return targetStr+josa;
    }

    public final static String buildEulJosa(String targetStr) throws IllegalArgumentException {
        String josa = "";
        char lastChar = targetStr.charAt(targetStr.length() - 1);
        
        if (lastChar < 0xAC00 || lastChar > 0xD7A3) {
            throw new IllegalArgumentException("It's not Korean Alphabet. Out of range.");
        }
        
        josa = (lastName - 0xAC00) % 28 > 0 ? "을" : "를";

        return targetStr+josa;
    }
}
