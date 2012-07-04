				
package com.citigroup.gerardo.pruebas.aspects;

public class AdderImpl implements Adder {

    public int add(int a, int b){
        return a+b;
    }

	@Override
	public int noArgs() {
		return 0;
	}


}
			