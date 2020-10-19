/**
 *
 */
package com.ssxs.util.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;


/**
 * Guava Cache是一个全内存的本地缓存实现，它提供了线程安全的实现机制。<br>
 * 整体上来说Guava cache 是本地缓存的不二之选，简单易用，性能好。<br>
 * Guava Cache有两种创建方式：<br>
 * 1. cacheLoader 　　<br>
 * 2. callable callback <br>
 * 通过这两种方法创建的cache，和通常用map来缓存的做法比，不同在于，<br>
 * 这两种方法都实现了一种逻辑——从缓存中取key X的值，如果该值已经缓存过了，则返回缓存中的值 ，<br>
 * 如果没有缓存过，可以通过某个方法来获取这个值。但不同的在于cacheloader的定义比较宽泛，是针对整个cache定义的 ，<br>
 * 可以认为是统一的根据key值load value的方法。而callable的方式较为灵活，允许你在get的时候指定。<br>
 * cache的参数说明：<br>
 * <p>
 * 　　回收的参数：<br>
 * 　　1. 大小的设置：<br>
 * CacheBuilder.maximumSize(long) <br>
 * CacheBuilder.weigher(Weigher)<br>
 * CacheBuilder.maxumumWeigher(long)<br>
 * 　　2. 时间：<br>
 * expireAfterAccess(long, TimeUnit)<br>
 * expireAfterWrite(long, TimeUnit)<br>
 * 　　3. 引用：<br>
 * CacheBuilder.weakKeys() <br>
 * CacheBuilder.weakValues()<br>
 * CacheBuilder.softValues()<br>
 * 　　4. 明确的删除：<br>
 * invalidate(key)<br>
 * invalidateAll(keys) <br>
 * invalidateAll()<br>
 * 　　5. 删除监听器：<br>
 * CacheBuilder.removalListener(RemovalListener)<br>
 *
 * <p>
 * 　　refresh机制：<br>
 * 　　1. LoadingCache.refresh(K) 在生成新的value的时候，旧的value依然会被使用。<br>
 * 　　2. CacheLoader.reload(K, V) 生成新的value过程中允许使用旧的value<br>
 * 　　3. CacheBuilder.refreshAfterWrite(long, TimeUnit) 自动刷新cache<br>
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:04
 * modifyTime:
 * modifyBy:
 */
public class GuavaCacheTest {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

//	@Test
//	public void testUserCacheLoader() throws Exception {
//		// 模拟数据
//		final List<Person> list = new ArrayList<Person>(5);
//		list.add(new Person("zhangsan", "1"));
//		list.add(new Person("lisi", "2"));
//		list.add(new Person("wangwu", "3"));
//
//		// 创建cache
//		LoadingCache<String, Person> cache = CacheBuilder.newBuilder()//
//				.refreshAfterWrite(1, TimeUnit.MINUTES)// 给定时间内没有被读/写访问，则回收。
//				// .expireAfterWrite(5, TimeUnit.SECONDS)//给定时间内没有写访问，则回收。
//				// .expireAfterAccess(3, TimeUnit.SECONDS)// 缓存过期时间为3秒
//				.maximumSize(100).// 设置缓存个数
//				build(new CacheLoader<String, Person>() {
//					@Override
//					/**  当本地缓存命没有中时，调用load方法获取结果并将结果缓存
//					 */
//					public Person load(String key) throws ExecutionException {
//						LOGGER.info(key + " load in cache");
//						return getPerson(key);
//					}
//
//					// 此时一般我们会进行相关处理，如到数据库去查询
//					private Person getPerson(String key) throws ExecutionException {
//						LOGGER.info(key + " query");
//						for (Person p : list) {
//							if (p.getName().equals(key))
//								return p;
//						}
//						return null;
//					}
//				});
//
//		cache.get("1");
//		cache.get("2");
//		cache.get("3");
//		LOGGER.info("======= sencond time  ==========");
//		cache.get("1");
//		cache.get("2");
//		cache.get("3");
//	}

    @Test
    public void testLoadingCache() throws Exception {

        LoadingCache<String, String> cahceBuilder = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {

            @Override
            public String load(String key) throws Exception {
                String strProValue = "hello " + key + "!";
                return strProValue;
            }

        });

        LOGGER.info("jerry value:" + cahceBuilder.get("jerry"));
        LOGGER.info("peida value:" + cahceBuilder.get("peida"));
        LOGGER.info("lisa value:" + cahceBuilder.get("lisa"));
        cahceBuilder.put("harry", "ssdded");
        LOGGER.info("harry value:" + cahceBuilder.get("harry"));
    }

    @Test
    public void testCallableCache() throws Exception {
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();
        String resultVal = cache.get("jerry", new Callable<String>() {
            public String call() {
                String strProValue = "hello " + "jerry" + "!";
                return strProValue;
            }
        });

        LOGGER.info("jerry value : " + resultVal);

        resultVal = cache.get("peida", new Callable<String>() {
            public String call() {
                String strProValue = "hello " + "peida" + "!";
                return strProValue;
            }
        });
        LOGGER.info("peida value : " + resultVal);
    }

}
