package com.nik.spring.data.chronic;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Store AGE as KEY and rest fields as value
 * */
public class ChronicAvgBPMapper extends Mapper<LongWritable, Text, IntWritable, Text>{
	String record;
	private boolean start = false;
	
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, IntWritable, Text>.Context context)
					throws IOException, InterruptedException {
		record = value.toString();
		if (start) {
			//String[] fields = record.split(",");
			try {
				context.write(
						new IntWritable(
								Integer.valueOf(record.substring(0, record.indexOf(",")))), 
								new Text(record.substring(record.indexOf(",")+1, record.length())));	
			} catch(NumberFormatException ex) {
				
			}
		}
		
		if ("@data".equals(record)) {
			start = true;
		}
	}
}
