				
package ar.com.scriptorum.pruebas.aspects.adder;

public class AdderImpl implements Adder {

    @Override
    public int add(int a, int b){
        return a+b;
    }

	@Override
	public int noArgs() {
		return 0;
	}


}
			