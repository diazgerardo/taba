package ar.com.scriptorum.workflow;

import java.util.HashMap;

public class CartographyFactory {
	
	private HashMap<Class<?>, Cartography> cartographies;

	/**
	 * @param cartographies the cartographies to set
	 */
	public void setCartographies(HashMap<Class<?>, Cartography> cartographies) {
		this.cartographies = cartographies;
	}

	/**
	 * @return the cartographies
	 */
	public HashMap<Class<?>, Cartography> getCartographies() {
		return cartographies;
	}
	
	/**
	 *  
	 * @param managedObjectClass
	 * @return Returns the associated cartography for a managed object
	 */
	public Cartography buildCartography(Class<?> managedObjectClass){
		return cartographies.get(managedObjectClass);
	}
	


}
