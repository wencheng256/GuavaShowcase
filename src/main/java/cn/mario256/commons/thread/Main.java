package cn.mario256.commons.thread;

import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Guava Thread showcase
 * <p>
 * Created by wencheng1 on 2017/4/28.
 */
public class Main {

    private ExecutorService executor;

    @Before
    public void init(){
        executor = Executors.newCachedThreadPool();
    }

    @Test
    public void listenableFuture(){
        ListenableFuture<Integer> listenableFuture = MoreExecutors.listeningDecorator(executor).submit(() -> 2 + 2);
        listenableFuture.addListener(() -> System.out.println("finished"), executor);
        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer integer) {
                System.out.println("ok"+integer);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(throwable.toString());
            }
        });
        System.out.println("main");

    }

    @Test
    public void faninFanout(){
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);
        ListenableFuture<Integer> future1 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(1);
                return 1;
            }
        });

        ListenableFuture<Integer> future2 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(2);
                return 2;
            }
        });

        ListenableFuture<Integer> future3 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                System.out.printf("3");
                return 3;
            }
        });

        ListenableFuture<Integer> future4 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(4);
                return 4;
            }
        });

        ListenableFuture<List<Integer>> finalFuture = Futures.allAsList(ImmutableSet.of(future1, future2, future3, future4));
        Futures.addCallback(finalFuture, new FutureCallback<List<Integer>>() {
            @Override
            public void onSuccess(List<Integer> integers) {
                System.out.println(integers);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



}
