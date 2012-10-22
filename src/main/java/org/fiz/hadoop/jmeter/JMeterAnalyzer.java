package org.fiz.hadoop.jmeter;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.OutputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


public class JMeterAnalyzer extends Configured implements Tool {

	@Override
	public int run(String[] args) throws Exception {
		String input, output;
	    if(args.length == 2) {
	      input = args[0];
	      output = args[1];
	    } else {
	      input = "your-input-dir";
	      output = "your-output-dir";
	    }

	    
	    JobConf conf = new JobConf(getConf(), JMeterAnalyzer.class); 
	    conf.setJobName(this.getClass().getName());
	    
	    FileInputFormat.setInputPaths(conf, new Path(input));
	    FileOutputFormat.setOutputPath(conf, new Path(output));
	    
	    conf.setMapperClass(JmeterMapper.class); 
	    conf.setReducerClass(JmeterReducer.class);
	    
	    conf.setMapOutputKeyClass(Text.class);
	    conf.setMapOutputValueClass(LongWritable.class);

	    conf.setOutputKeyClass(Text.class);
	    conf.setOutputValueClass(Text.class);
	    
	    conf.setOutputFormat(TextOutputFormat.class);

	    JobClient.runJob(conf);
	    
		return 0;
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new JMeterAnalyzer(), args);
	    System.exit(exitCode);

	}

}
