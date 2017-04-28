package cn.mario256.optional;

import org.junit.Test;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;

/**
 * Guava Avoid of null showcase
 * <p>
 * Created by wencheng1 on 2017/4/27.
 */
public class Main {

    @Test
    public void optional(){
        Object o1 = null;
        try {
            Optional<Object> aop = Optional.of(o1);  //will throw an exception
        } catch (NullPointerException e) {
            System.out.println("success");
        }
    }

    @Test
    public void otherApiAlsoAvoidOfNull(){
        try {
            ImmutableSet.of(1, 2, 3, 4, null);
        } catch (NullPointerException e) {
            System.out.println("success");
            return;
        }
        throw new IllegalArgumentException();
    }


}
