package ar.com.scriptorum.util.cyclo;

import java.util.List;

public interface CUnitDao {

	List<History> findHistory(CUnit cunit);

}
