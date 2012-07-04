package ar.com.scriptorum.rimas.silabeo;

public class UnknownWordStrategy extends FinalizerStrategy {

	@Override
	int findLenght(String st) {
		System.out.println("<<<Unknown word: "+st+">>>");
		return st.length();
	}

}
