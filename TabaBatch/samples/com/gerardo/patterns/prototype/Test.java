package com.gerardo.patterns.prototype;

class Test {
	   Complex c1 = new Complex();
	   Complex makeCopy() {
	      return (Complex)c1.clone();
	   }
	   public static void main(String[] args) {
	       Test tp = new Test();
	       Complex c2 = tp.makeCopy();
	       int[] mycopy = c2.getNums();
	       mycopy[0] = 5;

	       System.out.println();
	       System.out.print("local array: ");
	       for(int i = 0; i < mycopy.length; i++)
	          System.out.print(mycopy[i]);
	       System.out.println();

	       System.out.print("cloned object: ");
	       for(int ii = 0; ii < c2.nums.length; ii++)
	          System.out.print(c2.nums[ii]);
	       System.out.println();

	       System.out.print("original object: ");
	       for(int iii = 0; iii < tp.c1.nums.length; iii++)
	          System.out.print(tp.c1.nums[iii]);
	   }
	}
