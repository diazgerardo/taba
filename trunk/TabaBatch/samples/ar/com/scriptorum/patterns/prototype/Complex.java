package ar.com.scriptorum.patterns.prototype;

class Complex {
    int[] nums = {1,2,3,4,5};
    public Complex clone() {
        return new Complex();
    }
    int[] getNums() {
       return nums;
    }
}

