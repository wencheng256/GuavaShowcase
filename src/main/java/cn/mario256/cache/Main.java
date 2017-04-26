package cn.mario256.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Guava Cache showcase
 * <p>
 * Created by wencheng1 on 2017/4/26.
 */
public class Main {

    private LoadingCache<String, String> cache;

    @Before
    public void init(){
        cache = CacheBuilder.newBuilder().maximumSize(1).recordStats().build(new CacheLoader<String, String>() {
            @Override
            public String load(String s) throws Exception {
                return s+" hello world";
            }
        });
        cache.put("key", "key123 hello world");
    }

    @Test
    public void putCache(){
        cache.put("key", "key hello world");
    }

    @Test
    public void getCache() throws ExecutionException {
        System.out.println(cache.getIfPresent("key"));
        System.out.println(cache.get("key1", new Callable<String>() {
            public String call() throws Exception {
                return "hello";
            }
        }));
        System.out.println(cache.get("key 2"));
        System.out.println(cache.get("key"));
    }

    @Test
    public void evitCache() throws ExecutionException {
        cache.invalidate("key");
        System.out.println(cache.get("key"));
    }

    @Test
    public void dataCache() throws ExecutionException {
        System.out.println(cache.get("key"));
        System.out.println(cache.get("key1"));
        System.out.println(cache.stats().hitCount());
        System.out.println(cache.stats().hitRate());
    }



}
