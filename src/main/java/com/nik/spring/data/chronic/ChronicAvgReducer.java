package com.nik.spring.data.chronic;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ChronicAvgReducer extends Reducer<IntWritable, Text, IntWritable, Text> {
	Text output;
	String[] record;

	protected void reduce(IntWritable key, Iterable<Text> values,
			Reducer<IntWritable, Text, IntWritable, Text>.Context context)
					throws IOException, InterruptedException {

		Integer s_id = key.get();
		Integer sum = 0;
		Integer cnt = 0;
		Float avg_m = 0f;
		output = new Text();
		Integer totalRec = 0;
		Integer hypertensionCounter = 0;
		Integer anemiaCounter = 0;
		Integer arteryCounter = 0;

		for (Text value : values) {
			record = value.toString().split(",");
			totalRec = totalRec + 1;
			
			// Calculate BP
			try {
				sum = sum + Integer.parseInt(record[0]);
				cnt = cnt + 1;
			} catch (NumberFormatException e) {
				//e.printStackTrace();
			}
			
			// calculate hypertension
			if("yes".equals(record[17])) {
				hypertensionCounter = hypertensionCounter + 1;
			}
			
			// Coronary Artery Disease
			if("yes".equals(record[19])) {
				arteryCounter = arteryCounter + 1;
			}
						
			// Calculate Anemia
			if("yes".equals(record[22])) {
				anemiaCounter = anemiaCounter + 1;
			}
		}

		if(sum > 0 && cnt > 0) {
			avg_m = (float) (sum / cnt);	
		}
		output.set("Avg BP : "+avg_m.toString() 
					+"\t% Hypertension : "+(hypertensionCounter/totalRec)*100
					+"\t% Coronary Artery Disease : "+(arteryCounter/totalRec)*100
					+"\t% Anemia : "+(anemiaCounter/totalRec)*100);
		
		context.write(new IntWritable(s_id), output);
	}
}
