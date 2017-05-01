package cn.mario256.commons.order;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.List;

/**
 * Guava Ordering showcase
 * <p>
 * Created by wencheng1 on 2017/5/1.
 */
public class Main {

    @Test
    public void ordering(){
        Ordering<String> order = Ordering.natural().onResultOf(o -> Integer.parseInt(o));
        List<String> sortedList = order.sortedCopy(ImmutableList.of("1", "0", "2", "5", "4"));

        System.out.println(sortedList);
    }

}
