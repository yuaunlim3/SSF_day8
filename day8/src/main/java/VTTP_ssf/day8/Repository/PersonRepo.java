package VTTP_ssf.day8.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import VTTP_ssf.day8.Model.Person;

@Repository
public class PersonRepo {
    @Autowired
    @Qualifier("redis-0")
    RedisTemplate<String, String> redisTemplate;
    private final Logger logger = Logger.getLogger(PersonRepo.class.getName());

    public void savePersonInfo(Person person){
        if(!checkPerson(person.getFullName())){
            redisTemplate.opsForValue().set(person.getFullName(),person.toString());
        }

    }

    private Boolean checkPerson(String name){
        Set<String> keys = redisTemplate.keys("*");
        for(String key:keys){
            if(key.equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    public List<Person> getList(){
        Set<String> keys = redisTemplate.keys("*");
        List<Person> personList = new ArrayList<>();
        for(String key:keys){
            String personInfo = redisTemplate.opsForValue().get(key);
            //logger.info("Person: %s\n".formatted(key));
            Person person = Person.fromString(personInfo);
            personList.add(person);
        }

        return personList;
    }
}
