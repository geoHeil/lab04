// cc JoinMain, the main file
package org.myorg;


import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.*;

import org.apache.hadoop.tools.*;
 
// vv JoinMain
public class JoinMain extends Configured implements Tool {
  
  public static class KeyPartitioner extends Partitioner<TextPair, Text> {
    @Override
    public int getPartition(/*[*/TextPair key/*]*/, Text value, int numPartitions) {
      return (/*[*/key.getFirst().hashCode()/*]*/ & Integer.MAX_VALUE) % numPartitions;
    }
  }
  
  @Override
  public int run(String[] args) throws Exception {

      
    Job job = new Job(getConf(), "Join for Xpath");
    job.setJarByClass(getClass());
    
    Path InputPath1 = new Path(args[0]);
    Path InputPath2 = new Path(args[1]);
    Path outputPath = new Path(args[2]);
    
    MultipleInputs.addInputPath(job, InputPath1,
        TextInputFormat.class, JoinMapper1.class);
    MultipleInputs.addInputPath(job, InputPath2,
        TextInputFormat.class, JoinMapper2.class);
    FileOutputFormat.setOutputPath(job, outputPath);
    
    /*[*/job.setPartitionerClass(KeyPartitioner.class);
    job.setGroupingComparatorClass(TextPair.FirstComparator.class);/*]*/
    
    job.setMapOutputKeyClass(TextPair.class);
    
    job.setReducerClass(JoinReducer.class);

    job.setOutputKeyClass(Text.class);
    
    return job.waitForCompletion(true) ? 0 : 1;
  }
  
  public static void main(String[] args) throws Exception {
    int exitCode = ToolRunner.run(new JoinMain(), args);
    System.exit(exitCode);
  }
}
// ^^ JoinMain
