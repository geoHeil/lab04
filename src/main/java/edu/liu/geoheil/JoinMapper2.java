// cc JoinMapper2 Mapper for a reduce-side join
package edu.liu.geoheil;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

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
