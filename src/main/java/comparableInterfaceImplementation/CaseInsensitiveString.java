package comparableInterfaceImplementation;

class CaseInsensitiveString implements Comparable<CaseInsensitiveString>{

    private String s;

    public CaseInsensitiveString(String s) {
        if (s == null) {
            throw new NullPointerException();
        } else {
            this.s = s;
        }
    }

    //remove operations on objects of type String:
    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }


    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        cis.equals(s); //true
        s.equals(cis); //false
    }
    @Override
    public int compareTo(CaseInsensitiveString cis) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
    }
}
