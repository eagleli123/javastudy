package com.example.demo.java.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.TimeZone;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * @author: lihui
 * @date: 2020-06-02
 */
@Slf4j
public class JacksonUtil {

    private static GenericObjectPool<ObjectMapper> objectMapperPool = getPool(new ObjectMapperFactory());

    public static String writeValueAsString(Object value) {
        ObjectMapper mapper = null;
        try {
            mapper = objectMapperPool.borrowObject();
            return mapper.writeValueAsString(value);
        } catch (Exception e) {
            log.error("writeValueAsString {}", e.getMessage(), e);
        } finally {
            if (mapper != null) {
                objectMapperPool.returnObject(mapper);
            }
        }

        return null;
    }

    public static String writeValueAsString(Object value, TimeZone timeZone) {
        ObjectMapper mapper = null;
        try {
            mapper = objectMapperPool.borrowObject();
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            return mapper.setTimeZone(timeZone).writeValueAsString(value);
        } catch (Exception e) {
            log.error("writeValueAsString {}", e.getMessage(), e);
        } finally {
            if (mapper != null) {
                objectMapperPool.returnObject(mapper);
            }
        }

        return null;
    }

    public static GenericObjectPool getPool(PooledObjectFactory factory) {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(50000);
        config.setMaxWaitMillis(1000L);
        config.setMinEvictableIdleTimeMillis(1000 * 60 * 10L);
        config.setTimeBetweenEvictionRunsMillis(1000 * 60 * 30L);
        GenericObjectPool result = new GenericObjectPool(factory, config);
        return result;
    }

    public static class ObjectMapperFactory implements PooledObjectFactory<ObjectMapper> {

        @Override
        public PooledObject<ObjectMapper> makeObject() throws Exception {
            return new DefaultPooledObject(new ObjectMapper());
        }

        @Override
        public void destroyObject(PooledObject<ObjectMapper> p) throws Exception {

        }

        @Override
        public boolean validateObject(PooledObject<ObjectMapper> p) {
            return true;
        }

        @Override
        public void activateObject(PooledObject<ObjectMapper> p) throws Exception {

        }

        @Override
        public void passivateObject(PooledObject<ObjectMapper> p) throws Exception {

        }
    }
}
