package ar.com.scriptorum.patterns.factory;

//Let's say the interface is Display
interface Display {

   //load a file
   public void load(String fileName);

   //parse the file and make a consistent data type
   public void formatConsistency();

}
