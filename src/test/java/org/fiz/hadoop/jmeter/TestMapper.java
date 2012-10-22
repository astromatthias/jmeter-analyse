package org.fiz.hadoop.jmeter;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.MapDriver;
import org.fiz.hadoop.jmeter.JmeterMapper;
import org.junit.Before;
import org.junit.Test;



/**
 * MRUnit Test to test the Mapper
 * @author mhn
 *
 */
public class TestMapper {
	
	
	MapDriver<LongWritable, Text, Text, LongWritable> mapDriver;
	
	
	@Before
	public void setUp() { 
		mapDriver = new MapDriver<LongWritable, Text, Text, LongWritable>();
		JmeterMapper mapper = new JmeterMapper();
		mapDriver.setMapper(mapper);

	}
	
	
	@Test
	public void testMapper() {
		
		mapDriver.withInput(new LongWritable(1l), new Text("127,201,irgendwas")).
			withOutput(new Text("201"), new LongWritable(127l)).
			runTest();
	    
	  }
	
	

	
	

}
