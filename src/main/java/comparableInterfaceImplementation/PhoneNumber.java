package comparableInterfaceImplementation;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class PhoneNumber implements Comparable<PhoneNumber>{
    private final short areaCode, prefix, lineNum;

    PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "nr kierunkowy");
        this.prefix = rangeCheck(prefix, 999, "prefiks");
        this.lineNum = rangeCheck(lineNum, 999, "numer linii");
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(707,867,509), "Krystian");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;

        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNum == lineNum
                && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);

        return result;
    }

//    @Override
//    public int compareTo(PhoneNumber pn) {
//        int result = Short.compare(areaCode, pn.areaCode);
//        if(result == 0){
//            result = Short.compare(prefix, pn.prefix);
//        }
//        if(result == 0){
//            result = Short.compare(lineNum, pn.lineNum);
//        }
//    return result;
//    }

    //same method using methods that are constructing comparator
    @Override
    public int compareTo(PhoneNumber pn) {
        return COMPARATOR.compare(this, pn);
    }

    private static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
                    .thenComparing(pn -> pn.prefix)
                    .thenComparing(pn -> pn.lineNum);
}
