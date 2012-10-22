package org.fiz.hadoop.jmeter;

import java.io.IOException;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class JmeterMapper extends MapReduceBase implements
		Mapper<LongWritable, Text, Text, LongWritable> {


	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, LongWritable> output, Reporter reporter)
			throws IOException {
		
		    String line = value.toString();
		    String[] parameters = line.split(","); 
		    
		    // Time measured
		    String time = parameters[0];
		    // Return Code
		    String rc = parameters[1];
		    Long ltime = new Long(time);
		    output.collect(new Text(rc), new LongWritable(ltime));		
		
	}

	
	
	

}
