package br.com.concrete.teste;

import br.com.concrete.teste.interfaces.UserService;
import br.com.concrete.teste.models.Phone;
import br.com.concrete.teste.models.User;
import br.com.concrete.teste.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class UserTests {

    @Autowired
    UserRepository userRepository;

    private UUID uuid = null;

    @Test
    void createUser(){
        User user = newUser("APP TESTE", "EEEE@EEE.COM","123");
        user.setPhones(newPhoneList());
        User newUser = this.userRepository.save(user);
        Assertions.assertThat(newUser.getId()).isNotNull();
        Assertions.assertThat(newUser.getName()).isEqualTo("APP TESTE");
    }

    @Test
    void createUserError(){
        User user = newUser("APP TESTE2", "EEEWE@EEE.COM","123");
        user.setPhones(newPhoneList());
        User newUser = this.userRepository.save(user);
        Assertions.assertThat(newUser.getName()).isNotEqualTo("APP TESTE");
    }

    @Test
    void getProfileRepository(){
        User user = newUser("APP TESTE2", "EEEWEW@EEE.COM","123");
        user.setPhones(newPhoneList());
        User newUser = this.userRepository.save(user);
        User userTest = this.userRepository.findById(newUser.getId());
        Assertions.assertThat(userTest.getName()).isEqualTo("APP TESTE2");
    }


    User newUser(String name, String email, String password){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
    List<Phone> newPhoneList(){
        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(newPhone());
        return phoneList;
    }

    Phone newPhone(){
        Phone phone = new Phone();
        phone.setDdd("32");
        phone.setNumber("323232323232");
        return phone;
    }
}
