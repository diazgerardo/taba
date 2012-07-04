package com.gerardo.patterns.decorator;
import java.util.Random;
class Number {
   public void print() {
       System.out.println(new Random().nextInt());
   }
}
