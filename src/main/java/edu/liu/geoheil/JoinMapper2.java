// cc JoinMapper2 Mapper for a reduce-side join
package edu.liu.geoheil;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

// vv JoinMapper2
public class JoinMapper2
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

        String realKey = str.substring(0, str.indexOf(' '));
        textFirst.set(realKey.substring(0, realKey.length() - 4));
        textSecond.set(realKey);
        keysOut.set(textFirst, textSecond);
        valueOut.set(str.substring(str.indexOf(' ') + 1));

        logger.debug("KEY " + keysOut);
        logger.debug("VALUE " + valueOut);

        context.write(keysOut, valueOut);
    }
}
