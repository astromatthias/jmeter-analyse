package org.fiz.hadoop.jmeter;



import java.io.IOException;
import java.util.Iterator;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class JmeterReducer extends MapReduceBase implements
		Reducer<Text, LongWritable, Text, Text> {

	@Override
	public void reduce(Text key, Iterator<LongWritable> values,
			OutputCollector<Text, Text> output, Reporter reporter)
			throws IOException {

		   // calculate the average of the values. 
			 Long time = 0l;
			 int count = 0;
			 
			for (Iterator<LongWritable> iterator = values; iterator.hasNext();) {
				count++;
				LongWritable atomictime = (LongWritable) iterator.next();
				
				time = time + (Long)atomictime.get();
				
			}
			 
			 Double average = time.doubleValue() / count; 
			 reporter.incrCounter("General", "Total Amount", count);
			 reporter.incrCounter("General", "Total Time", time);
			 reporter.incrCounter("General", "Total Average", average.longValue());
			 output.collect(key, new Text(average.toString() + "\t" + count + "\t" + time.toString()));
		
		
		
	}
	
	
}
