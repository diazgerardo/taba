package ar.com.scriptorum.patterns.behavioural.command;

import java.util.*;
public class CommandPattern {

interface Command { void execute(); }

static class DomesticEngineer implements Command {
   public void execute() {
      System.out.println( "take out the trash" );
}  }

static class Politician implements Command {
   public void execute() {
      System.out.println( "take money from the rich, take votes from the poor" );
}  }

static class Programmer implements Command {
   public void execute() {
      System.out.println( "sell the bugs, charge extra for the fixes" );
}  }

public static List<Command> produceRequests() {
   List<Command> queue = new ArrayList<Command>();
   queue.add( new DomesticEngineer() );
   queue.add( new Politician() );
   queue.add( new Programmer() );
   return queue;
}

public static void workOffRequests( List<Command> queue ) {
   for (Command c : queue )
      c.execute();
}

public static void main( String[] args ) {
   List<Command> queue = produceRequests();
   workOffRequests( queue );
}}
