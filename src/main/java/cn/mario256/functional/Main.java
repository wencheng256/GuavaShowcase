package cn.mario256.functional;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collection;

/**
 * Guava Functional showcase
 * <p>
 * Created by wencheng1 on 2017/4/26.
 */
public class Main {

    Collection list = Lists.newArrayList(1, 2, 3, 4, 5);


    @Test
    public void map() {
        Collection mappedList = Collections2.transform(list, o -> {
            if (o.equals(2)) {
                return 12;
            } else {
                return o;
            }
        });
        System.out.printf(mappedList.toString());
    }

    @Test
    public void filter() {
        Collection filteredList = Collections2.filter(list, o -> !o.equals(2));
        System.out.printf(filteredList.toString());
    }

}
