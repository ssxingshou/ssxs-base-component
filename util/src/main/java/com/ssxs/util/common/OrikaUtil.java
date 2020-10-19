package com.ssxs.util.common;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/1/6 11:52
 * modifyTime:
 * modifyBy:
 */
public class OrikaUtil {
    /**
     * 工厂类初始化
     */
    public static volatile MapperFactory factory = null;
    // public static ReentrantLock lock = new ReentrantLock();

    /**
     * todo 这里使用隐式锁synchronized，问题不大，在并发量比较小的情况下，使用synchronized是个不错的选择，
     * todo 但是在并发量比较高的情况下，其性能下降很严重，此时ReentrantLock是个不错的方案。
     * 显式锁不像内置锁那样会自动释放，使用显式锁一定要在finally块中手动释放，如果获取锁后由于异常的原因没有释放锁，
     * 那么这把锁将永远得不到释放！将unlock()放在finally块中，保证无论发生什么都能够正常释放。
     * 当需要同步时请优先考虑更安全的更易用的隐式锁。
     *
     * @return
     */
    public static MapperFactory getFactoryInstance() {
        if (factory == null) {
/*            lock.lock();
            try {
                factory = new DefaultMapperFactory.Builder().build();
            } finally {
                lock.unlock();
            }*/
            synchronized (MapperFactory.class) {
                if (factory == null) {
                    factory = new DefaultMapperFactory.Builder().build();
                }
            }
        }
        return factory;
    }

    /**
     * @param sourceObject
     * @param destinationClass
     * @param <S>
     * @param <D>
     * @return
     */
    public static <S, D> D copyAtoB(S sourceObject, Class<D> destinationClass) {
        return getFactoryInstance().getMapperFacade().map(sourceObject, destinationClass);
    }

    /**
     * @param source
     * @param destinationClass
     * @param <S>
     * @param <D>
     * @return
     */
    public static <S, D> List<D> copyAlistToBlist(Iterable<S> source, Class<D> destinationClass) {
        return getFactoryInstance().getMapperFacade().mapAsList(source, destinationClass);
    }

    /**
     * @param source
     * @param sourceType
     * @param destinationType
     * @param <Sk>
     * @param <Sv>
     * @param <D>
     * @return
     */
    public static <Sk, Sv, D> List<D> mapToList(Map<Sk, Sv> source, Type<? extends Map<Sk, Sv>> sourceType,
                                                Type<D> destinationType) {
        return getFactoryInstance().getMapperFacade().mapAsList(source, sourceType, destinationType);
    }

    /**
     * @param source
     * @param sourceType
     * @param destinationType
     * @param <Sk>
     * @param <Sv>
     * @param <D>
     * @return
     */
    public static <Sk, Sv, D> Set<D> mapToSet(Map<Sk, Sv> source, Type<? extends Map<Sk, Sv>> sourceType,
                                              Type<D> destinationType) {
        return getFactoryInstance().getMapperFacade().mapAsSet(source, sourceType, destinationType);
    }

    /**
     * @param source
     * @param sourceType
     * @param destinationType
     * @param <S>
     * @param <Dk>
     * @param <Dv>
     * @return
     */
    public static <S, Dk, Dv> Map<Dk, Dv> listToMap(Iterable<S> source, Type<S> sourceType,
                                                    Type<? extends Map<Dk, Dv>> destinationType) {
        return getFactoryInstance().getMapperFacade().mapAsMap(source, sourceType, destinationType);
    }

    /**
     * @param source
     * @param sourceType
     * @param destinationType
     * @param <Sk>
     * @param <Sv>
     * @param <Dk>
     * @param <Dv>
     * @return
     */
    public static <Sk, Sv, Dk, Dv> Map<Dk, Dv> mapToMap(Map<Sk, Sv> source, Type<? extends Map<Sk, Sv>> sourceType,
                                                        Type<? extends Map<Dk, Dv>> destinationType) {
        return getFactoryInstance().getMapperFacade().mapAsMap(source, sourceType, destinationType);
    }

}
