// cc JoinMapper1 Mapper for a reduce-side join

package edu.liu.geoheil;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/***
 * Map task 1: Take a triple from file01, check whether the attribute name is
 * “species” and the attribute value contains the string “P_KK”. If this is true,
 * retrieve the prefix of the current dewey_pid and send it as the key to the reduce
 * task.
 */
//vv JoinMapper1
public class JoinMapper1
        extends Mapper<LongWritable, Text, TextPair, Text> {

/* here define the variables */


    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

/* here the code for retrieving the triples from file01 and send the prefix of the dewey_pid as key */


    }
}
//^^ JoinMapper1
