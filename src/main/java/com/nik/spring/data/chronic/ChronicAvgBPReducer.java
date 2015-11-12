package com.nik.spring.data.chronic;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class ChronicAvgBPReducer extends Reducer<IntWritable, IntWritable, IntWritable, FloatWritable> {
	protected void reduce(IntWritable key, Iterable<IntWritable> values, Reducer<IntWritable, IntWritable, IntWritable, FloatWritable>.Context context) throws IOException, InterruptedException {
		Integer s_id = key.get();
		Integer sum = 0;
		Integer cnt = 0;
		
		for (IntWritable value:values) {
			sum = sum + value.get();
			cnt = cnt + 1;
		}
		
		Float avg_m = (float) (sum/cnt);
		context.write(new IntWritable(s_id), new FloatWritable(avg_m));
	}
}