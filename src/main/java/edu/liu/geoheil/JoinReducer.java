// cc JoinReducer Reducer for join

package edu.liu.geoheil;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

// vv JoinReducer
public class JoinReducer extends Reducer<TextPair, Text, Text, Text> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void reduce(TextPair key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

        logger.debug("Key" + key);
        logger.debug("Text" + values);

      /* here comes the reducer code */


    }
}
