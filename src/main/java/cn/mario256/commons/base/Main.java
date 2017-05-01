package cn.mario256.commons.base;

import com.google.common.base.Defaults;
import org.junit.Test;

/**
 * 此处说明此类的作用
 * <p>
 * Created by wencheng1 on 2017/4/30.
 */
public class Main {

    @Test
    public void defaults(){
        System.out.println(Defaults.defaultValue(String.class));
        System.out.println(Defaults.defaultValue(Integer.class));
        System.out.println(Defaults.defaultValue(Boolean.class));
    }

}
