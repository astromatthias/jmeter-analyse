package org.fiz.hadoop.jmeter;

import org.junit.Assert;
import org.junit.Test;

public class TestLine {
	
	@Test
	public void testSplit() { 
		
		String line ="127,201,irgendwas";
		
		String[] parameters = line.split(","); 
		    
		// Time measured
		String time = parameters[0];
		// Return Code
		String rc = parameters[1];
		Long ltime = new Long(time);
		
		Assert.assertTrue("Time ist gleich?", time.equals("127"));
		Assert.assertTrue("RC ist gleich ?", rc.equals("201"));
		
		
	}

}
