// cc JoinMapper1 Mapper for a reduce-side join

package edu.liu.geoheil;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/***
 * Map task 1: Take a triple from file01, check whether the attribute name is
 * “species” and the attribute value contains the string “P_KK”. If this is true,
 * retrieve the prefix of the current dewey_pid and send it as the key to the reduce
 * task.
 * <p>
 * dealing with list of products / reference
 */
//vv JoinMapper1
public class JoinMapper1
        extends Mapper<LongWritable, Text, TextPair, Text> {

/* here define the variables */

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Text valueOut = new Text();
    private Text textFirst = new Text();
    private Text textSecond = new Text();
    private TextPair keysOut = new TextPair();

    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        /* here the code for retrieving the triples from file01 and send the prefix of the dewey_pid as key */
        String str = value.toString();
        /**
         Given a dewey_pid (id) from file01 or file02, we can easily obtain the dewey_pid
         of reaction by removing the last two digits from id.
         For instance, if the dewey_pid from file01 is 1.1 .3 .4
         then the dewey_pid of reaction would be 1.1 --> (-) 5 as 4 for digits + point
         */
        String realKey = str.substring(0, str.indexOf(' '));
        textFirst.set(realKey.substring(0, realKey.length() - 4));
        textSecond.set(realKey);
        keysOut.set(textFirst, textSecond);

        /**
         * check whether the attribute name is “species” and the attribute value contains the string “P_KK”.
         * If this is true, retrieve the prefix of the current dewey_pid and send it as the key to the reduce task.
         */
        valueOut.set(str.substring(str.indexOf(' ') + 1));

        if (value.toString().contains("P_KK")) {
            // Only filter for P_KK items
            logger.debug("KEY " + keysOut);
            logger.debug("VALUE " + valueOut);

            context.write(keysOut, valueOut);
        }
    }
}
