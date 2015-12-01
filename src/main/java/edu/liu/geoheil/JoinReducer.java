// cc JoinReducer Reducer for join

package edu.liu.geoheil;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

// vv JoinReducer
public class JoinReducer extends Reducer<TextPair, Text, Text, Text> {

    @Override
    protected void reduce(TextPair key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

      /* here comes the reducer code */


    }
}
// ^^ JoinReducer
