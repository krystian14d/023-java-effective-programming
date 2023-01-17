package redefiningEqualsMethod;

class CaseInsensitiveString {
    private String s;

    public CaseInsensitiveString(String s) {
        if (s == null) {
            throw new NullPointerException();
        } else {
            this.s = s;
        }
    }

//    //error - symmetry is not kept!
//    @Override
//    public boolean equals(Object o) {
//        if(o instanceof CaseInsensitiveString){
//            return s.equalsIgnoreCase(((CaseInsensitiveString)o).s);
//        }
//        if(o instanceof String){ //one-way cooperation
//            return s.equalsIgnoreCase((String)o);
//        }
//        return false;
//    }


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


}
