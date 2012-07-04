package ar.com.scriptorum.rimas.silabeo;

public class MonosilaboStrategy extends FinalizerStrategy {

	@Override
	int findLenght(String st) {
		return st.length();
	}

}
