package VTTP_ssf.day8.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;

public class ListRepo {

    @Autowired
    @Qualifier("redis-0")
    RedisTemplate<String, String> redisTemplate;

    public void leftPush(String redisKey, String value){
        redisTemplate.opsForList().leftPush(redisKey, value);
    }

    public void rightPush(String redisKey, String value){
        redisTemplate.opsForList().rightPush(redisKey, value);
        
    }

    
    public void leftPop(String redisKey){
        redisTemplate.opsForList().leftPop(redisKey);
    }

    public void rightPop(String redisKey){
        redisTemplate.opsForList().rightPop(redisKey);
        
    }

    public Long size(String redisKey){
        return redisTemplate.opsForList().size(redisKey);
    }

    public String get(String redisKey,Integer index){
        return redisTemplate.opsForList().index(redisKey, index);
    }

    public List<String> getList(String redisKey, Integer index){
        return redisTemplate.opsForList().range(redisKey, 0, -1);
    }
}
