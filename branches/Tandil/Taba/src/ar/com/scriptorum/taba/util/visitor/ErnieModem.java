package ar.com.scriptorum.taba.util.visitor;

public class ErnieModem implements Modem
{
public void dial(String pno){}
public void hangup(){}
public void send(char c){}
public char recv() {return 0;}
public void accept(ModemVisitor v)
{
try
{
ErnieModemVisitor ev = (ErnieModemVisitor)v;
ev.visit(this);
}
catch (ClassCastException e)
{}
}
String internalPattern = "C is too slow";
}