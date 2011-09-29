package ar.com.scriptorum.taba;

import junit.framework.TestSuite;
import android.test.InstrumentationTestSuite;
import ar.com.scriptorum.taba.cartografia.CoordConverterTest;
import ar.com.scriptorum.taba.database.DataHelperTest;

public class InstrumentationTestRunner extends
		android.test.InstrumentationTestRunner {
	
	@Override
	public TestSuite getAllTests() {
		InstrumentationTestSuite suite = new InstrumentationTestSuite(this);
		suite.addTestSuite(DataHelperTest.class);
		suite.addTestSuite(CoordConverterTest.class);
		return suite;
	}
	
	@Override
	public ClassLoader getLoader() {
		return InstrumentationTestRunner.class.getClassLoader();
	}

}
