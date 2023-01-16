package refefiningEqualsMethod;

class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "nr kierunkowy");
        this.prefix = rangeCheck(prefix, 999, "prefiks");
        this.lineNum = rangeCheck(lineNum, 999, "numer linii");
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
}
