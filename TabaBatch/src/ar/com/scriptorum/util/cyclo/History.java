package ar.com.scriptorum.util.cyclo;

public interface History {
	
	void listdiffs();

	void print();

	String printable();

	void put(CUnit before);
}
