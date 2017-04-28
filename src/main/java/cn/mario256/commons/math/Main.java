package cn.mario256.commons.math;

import com.google.common.math.IntMath;
import org.junit.Test;

/**
 * Guava Math showcase
 * <p>
 * Created by wencheng1 on 2017/4/26.
 */
public class Main {

    @Test
    public void forze(){
        System.out.println(IntMath.checkedAdd(100, 100));           //fast-fail if stack overflow
        System.out.println(IntMath.pow(2, 3));
    }

}
