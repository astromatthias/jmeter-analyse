package org.fiz.hadoop.jmeter;


import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

public class TestReducer {
	
	ReduceDriver<Text,LongWritable,Text,Text> driver; 
	
	@Before
	public void setUp() { 
		driver = new ReduceDriver<Text,LongWritable,Text,Text>();
		JmeterReducer reducer = new JmeterReducer();
		driver.setReducer(reducer);
	}
	
	@Test
	public void testReducer() { 
		
		List<LongWritable> list = new ArrayList<LongWritable>();
		list.add(new LongWritable(127l));
		String output = "127.0" + "\t" + "1" + "\t" + "127";
		driver.withInput(new Text("201"), list).withOutput(new Text("201"), new Text(output)).runTest();
		
		
	}
	

}
