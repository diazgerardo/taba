package ar.com.scriptorum.patterns.decorator;
import java.util.Random;
class Number {
   public void print() {
       System.out.println(new Random().nextInt());
   }
}
