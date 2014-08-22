package ar.com.scriptorum.util.cyclo;

import java.util.ArrayList;
import java.util.List;

public class FakeCUNitDao implements CUnitDao {

	@Override
	public List<History> findHistory(CUnit cunit) {
		ArrayList<History> list = new ArrayList<History>();
		History hst = new HistoryImpl();
		CUnitImpl before = new CUnitImpl();
		before.setName("prev");
		hst.put(before);
		CUnitImpl  after = new CUnitImpl();
		after.setName("after");
		hst.put(after);
		list.add(hst);
		return list;
	}

}
