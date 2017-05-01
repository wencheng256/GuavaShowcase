package cn.mario256.commons.service;

import com.google.common.util.concurrent.AbstractService;
import org.junit.Test;

import java.util.Date;

/**
 * Guava Service showcase
 * <p>
 * Created by wencheng1 on 2017/4/30.
 */
public class Main {

    public static class TestService extends AbstractService{

        private Thread th;
        private Boolean status = true;

        public TestService(){
            th = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(status){
                        System.out.println(new Date());
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        @Override
        protected void doStart() {
            th.start();
        }

        @Override
        protected void doStop() {
            status = false;
        }
    }

    @Test
    public void service(){
        TestService service = new TestService();
        service.startAsync();
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.stopAsync();
    }

}
