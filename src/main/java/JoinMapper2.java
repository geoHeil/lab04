// cc JoinMapper2 Mapper for a reduce-side join
package org.myorg;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

// vv JoinMapper2
public class JoinMapper2
    extends Mapper<LongWritable, Text, TextPair, Text> {

        /* here define the variables */

  @Override
  protected void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

          
/* here the code for retrieving the triples from file01 and send the prefix of the dewey_pid as key */
    
  }
}
// ^^ JoinMapper2
