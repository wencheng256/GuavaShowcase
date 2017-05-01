package cn.mario256.commons.enums;

import com.google.common.base.Enums;
import com.google.common.base.Optional;
import org.junit.Test;

/**
 * Guava enums showcase
 * <p>
 * Created by wencheng1 on 2017/4/28.
 */
public class Main {

    enum Color{
        red, black, yellow, blue, none
    }

    @Test
    public void dynamicGetEnum(){
        Optional<Color> black = Enums.getIfPresent(Color.class, "black");
        System.out.println(black.or(Color.none));

        Optional<Color> green = Enums.getIfPresent(Color.class, "green");
        System.out.println(green.or(Color.none));
    }

    @Test
    public void getEnumConverter(){
        System.out.println(Enums.stringConverter(Color.class).convert("yellow"));
        try {
            System.out.println(Enums.stringConverter(Color.class).convert("green"));
        } catch (IllegalArgumentException e) {
            System.out.println("if not exist, it will throw an exception");
        }
    }
}
