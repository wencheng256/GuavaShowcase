package cn.mario256.commons.hash;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.junit.Test;

/**
 * Guava Hash showcase
 * <p>
 * Created by wencheng1 on 2017/4/26.
 */
public class Main {

    public void init(){

    }

    @Test
    public void md5(){
        HashFunction md5Function = Hashing.md5();
        Hasher hasher = md5Function.newHasher();
        hasher.putString("hello world", Charsets.UTF_8);
        System.out.println(hasher.hash());
    }

    @Test
    public void bloomFilter(){
        BloomFilter<Object> bloomFilter =
                BloomFilter.create((Funnel<Object>) (o, primitiveSink) -> primitiveSink.putString(o.toString(), Charsets.UTF_8), 1000L);
        bloomFilter.put("1");
        System.out.println(String.valueOf(bloomFilter.mightContain("1")));
        System.out.println(String.valueOf(bloomFilter.mightContain("2")));
    }

}
