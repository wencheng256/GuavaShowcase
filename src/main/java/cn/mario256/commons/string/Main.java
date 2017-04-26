package cn.mario256.commons.string;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.junit.Test;

/**
 * Guava String showcase
 * <p>
 * Created by wencheng1 on 2017/4/26.
 */
public class Main {

    @Test
    public void joiner(){
        Joiner joiner = Joiner.on(",");
        String joinedString = joiner.skipNulls().join(Lists.newArrayList(1, 2, 3, 4, 5));
        System.out.println(joinedString);
    }

    @Test
    public void spliter(){
        Iterable<String> splitList = Splitter.on(",").limit(5).split("1 ,2 ,3,4,5,6,7");
        System.out.println(splitList);
    }

    @Test
    public void charMatcher(){
        String str = CharMatcher.ascii().replaceFrom("123,45,5,6,7", "1");
        System.out.println(str);
    }


}
