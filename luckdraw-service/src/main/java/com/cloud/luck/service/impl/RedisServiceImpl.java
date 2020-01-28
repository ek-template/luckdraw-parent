package com.cloud.luck.service.impl;


import com.cloud.luck.service.IRedisService;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in 2020/1/28 22:10
 * @Title RedisServiceImpl.java
 * <p>Description: [ TODO ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:  </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RedisServiceImpl implements IRedisService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void setMap(String mapName, Map<String, Object> modelMap) {
        HashOperations<String, String, Object> hps = redisTemplate.opsForHash();
        hps.putAll(mapName, modelMap);
    }

    @Override
    public Map getMap(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    @Override
    public boolean getMapExists(String key, String subKey) {
        return redisTemplate.opsForHash().hasKey(key, subKey);
    }

    @Override
    public void deleteMap(String key, String subKey) {
        redisTemplate.opsForHash().delete(key, subKey);
    }

    @Override
    public Boolean delete(String key) {
        Boolean delete = redisTemplate.delete(key);
        return delete;
    }

}
