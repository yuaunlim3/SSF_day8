package VTTP_ssf.day8.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VTTP_ssf.day8.Model.Person;
import VTTP_ssf.day8.Repository.PersonRepo;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    public void savePersonInfo(Person person) {
        Random rand = new SecureRandom();
        int id = rand.nextInt();

        person.setId(id);
        personRepo.savePersonInfo(person);

    }

    public List<Person> getInfo(){
        return personRepo.getList();
    }
}
