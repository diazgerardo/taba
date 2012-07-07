package ar.com.scriptorum.aspects.boot;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class Boot {

   public static void main(final String[] args) throws Exception {
      BeanFactory ctx = new ClassPathXmlApplicationContext("plain.xml");
      FooService foo = (FooService) ctx.getBean("fooService");
      for(int i=0;i<10;i++)
    	  foo.getFoo("Pengo"+i, i);
      
   }
}