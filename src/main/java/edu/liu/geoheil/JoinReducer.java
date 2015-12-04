// cc JoinReducer Reducer for join

package edu.liu.geoheil;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Similar to http://www.codeproject.com/Articles/869383/Implementing-Join-in-Hadoop-Map-Reduce
 */
public class JoinReducer extends Reducer<TextPair, Text, Text, Text> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Text resultOutput = new Text();
    private Text resultKey = new Text();

    @Override
    protected void reduce(TextPair key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

        logger.debug("Key" + key);
        logger.debug("Text" + values);

        resultKey.set("KEY");
        resultOutput.set("GGG");

      /* here comes the reducer code */

//        values.forEach(v -> join(v));

        context.write(resultKey, resultOutput);
    }

}
