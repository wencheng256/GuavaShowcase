package cn.mario256.precondition;

import com.google.common.base.Preconditions;
import org.junit.Test;

/**
 * Prediction Test
 * <p>
 * Created by wencheng1 on 2017/4/27.
 */
public class Main {

    @Test
    public void testPrecondition(){
        Preconditions.checkArgument(1 == 2, "arguement should be equal to 2");
    }

}
