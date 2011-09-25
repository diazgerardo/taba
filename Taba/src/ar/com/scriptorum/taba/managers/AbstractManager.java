package ar.com.scriptorum.taba.managers;

/**
 * Managers are expected to talk each other in order to allow them to delegate into 
 * their better known, more specific services the duties required to acomplish the
 * tasks required by any single process in the system
 * 
 * In other words, Managers deal by one side with processes and by the other side with
 * tasks,  while Services deal with the tasks delegated to them, splitting them into
 * more specific duties
 * 
 * @author gd
 *
 */
// every Manager is expected to extend this class
public abstract class AbstractManager {

}
