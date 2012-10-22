package org.fiz.hadoop.jmeter;

import org.junit.Test;

public class testLine {
	
	@Test
	public void testSplit() { 
		
		String line ="127,201,irgendwas";
		
		String[] parameters = line.split(","); 
		    
		// Time measured
		String time = parameters[0];
		// Return Code
		String rc = parameters[1];
		Long ltime = new Long(time);
		
		System.out.println("Time " + ltime + " Retrn code " + rc);
		
		
	}

}
