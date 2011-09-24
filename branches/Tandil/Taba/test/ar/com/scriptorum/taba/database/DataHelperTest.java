package ar.com.scriptorum.taba.database;

import java.util.List;

import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;

@SuppressWarnings("rawtypes")
public class DataHelperTest extends ActivityInstrumentationTestCase2 {

	DataHelper dataHelper;
	Context ctx;

	@SuppressWarnings("unchecked")
	public DataHelperTest() {
		super("ar.scriptorum.taba.database", DataHelper.class);
	}

	@Override
	public void setUp() {
		try {
			super.setUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ctx = this.getInstrumentation().getContext();
		dataHelper = new DataHelper(ctx);
	}

	public void testDataHelperCreation() {
		assertNotNull(dataHelper);
	}

	public void testExerciseDataHelper() {
		dataHelper.deleteAll();
		dataHelper.insert("escobar");
		dataHelper.insert("campana");
		dataHelper.insert("zarate");
		List<String> names = dataHelper.selectAll();
		StringBuilder sb = new StringBuilder();
		assertTrue(names.size() == 3);
		for (String name : names) {
			sb.append(name);
		}
		assertTrue("zarateescobarcampana".equals(sb.toString()));
	}

}
