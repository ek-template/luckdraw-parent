package com.cloud.luck.service;

import java.util.Map;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in 2020/1/28 22:08
 * @Title IRedisService.java
 * <p>Description: [ Redis服务类 ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:  </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
public interface IRedisService {

    /**
     * Description: [ 新增Map ]
     *
     * @param
     * @param mapName
     * @param modelMap
     * @return void
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 22:08
     * <p>File:  </p>
     */
    void setMap(String mapName, Map<String, Object> modelMap);

    /**
     * Description: [ 获取Map ]
     *
     * @param
     * @param key
     * @return java.util.Map
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 22:08
     * <p>File:  </p>
     */
    Map getMap(String key);

    /**
     * Description: [ 判断是否存在 ]
     *
     * @param
     * @param key
     * @param subKey
     * @return boolean
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 22:08
     * <p>File:  </p>
     */
    boolean getMapExists(String key, String subKey);

    /**
     * Description: [ 删除Map ]
     *
     * @param
     * @param key
     * @param subKey
     * @return void
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 22:08
     * <p>File:  </p>
     */
    void deleteMap(String key, String subKey);

    /**
     * Description: [ 根据key删除 ]
     *
     * @param
     * @param key
     * @return java.lang.Boolean
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 22:09
     * <p>File:  </p>
     */
    Boolean delete(String key);
}
