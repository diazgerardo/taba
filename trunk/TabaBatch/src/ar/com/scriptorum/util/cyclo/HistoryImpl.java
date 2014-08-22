package ar.com.scriptorum.util.cyclo;

import java.util.ArrayList;
import java.util.List;

public class HistoryImpl implements History {

	String diffs = "";
	List<CUnit> list = new ArrayList<CUnit>();

	@Override
	public void print() {
		System.out.println(diffs);
	}

	public void listdiffs() {
		CUnit cunit[] = new CUnit[2];
		for (int i = 0; i < list.size()-1; i++) {
			cunit[0] = list.get(i);
			cunit[1] = list.get(i + 1);
			compare(cunit);
		}
	}

	private void compare(CUnit[] cunits) {

		diffs = diffs + " names "
				+ cunits[0].getName().equals(cunits[1].getName());

	}

	@Override
	public String printable() {
		return diffs;
	}

	@Override
	public void put(CUnit cunit) {
		list.add(cunit);

	}

}
