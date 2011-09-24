package ar.com.scriptorum.taba.view.test;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import ar.com.scriptorum.taba.view.Taba;


public class TabaTest extends ActivityInstrumentationTestCase2<Taba> {
	private Taba mAct;
	private Intent intent;
	private String resourceString;
	
	public TabaTest() {
		super("com.scriptorum.view", Taba.class);
	}
	  @Override
	    protected void setUp() throws Exception {
	        super.setUp();
	        mAct = this.getActivity();
	        intent = (Intent) mAct.getIntent();
	        resourceString = mAct.getString(ar.com.scriptorum.taba.view.R.string.hello);
	    }

	    public void testPreconditions() {
	        assertNotNull(intent);
	        assertNotNull(mAct);
	        assertNotNull(resourceString);
	      }
	    
}
