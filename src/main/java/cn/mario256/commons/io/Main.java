package cn.mario256.commons.io;

import com.google.common.base.Charsets;
import com.google.common.io.CharSource;
import com.google.common.io.CharStreams;
import com.google.common.io.Resources;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Guava IO showcase
 * <p>
 * Created by wencheng1 on 2017/4/26.
 */
public class Main {

    @Test
    public void stream() throws IOException {
        String hello = CharStreams.toString(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("hello")));
        System.out.println(hello);

    }

    @Test
    public void source() throws IOException {
        CharSource charSource = Resources.asCharSource(new URL("http://www.baidu.com"), Charsets.UTF_8);
        String content = charSource.read();
        System.out.println(content);
    }

    @Test
    public void sink(){
    }

}
