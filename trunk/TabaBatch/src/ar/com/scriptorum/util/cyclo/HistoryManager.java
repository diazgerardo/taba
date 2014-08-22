package ar.com.scriptorum.util.cyclo;

import java.util.List;

import org.junit.Test;

public class HistoryManager {

	CUnitDao cunitDao = new FakeCUNitDao();
	@Test
	public void showHist() {
		
		CUnit cunit = null;
		List<? extends History> list = this.findHistory(cunit);
		if(!list.isEmpty()) {
			for(History change : list) {
				change.listdiffs();
				change.print();
				System.out.println(change.printable());
			}
		}
		
	}

	private List<? extends History> findHistory(CUnit cunit) {
		
		List<History> list = cunitDao.findHistory(cunit);
		return list;
	}
}
