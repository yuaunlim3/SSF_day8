package VTTP_ssf.day8.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ValueRepository {
    @Autowired
    @Qualifier("redis-0")
    RedisTemplate<String, String> redisTemplate;

    // set redisKey value
    public void setvalue(String redisKey, String value) {
        redisTemplate.opsForValue().set(redisKey, value);
    }

    // get redisKey value
    public String getValue(String redisKey, String value) {
        return redisTemplate.opsForValue().get(redisKey);
    }

    // incr redisKey
    public void incrementValue(String redisKey) {
        redisTemplate.opsForValue().increment(redisKey);
    }

    // incre redisKey amount
    public void incrementValue(String redisKey, Integer amount) {
        redisTemplate.opsForValue().increment(redisKey, amount);
    }

    // decr redisKey
    public void decrementValue(String redisKey) {
        redisTemplate.opsForValue().decrement(redisKey);
    }

    // decr redisKey amount
    public void decrementValue(String redisKey, Integer amount) {
        redisTemplate.opsForValue().decrement(redisKey, amount);
    }

    // delete redisKey
    public void deleteKey(String redisKey) {
        redisTemplate.delete(redisKey);
    }

    // exist redisKey
    public Boolean checkKey(String redisKey) {
        return redisTemplate.hasKey(redisKey);
    }

}
