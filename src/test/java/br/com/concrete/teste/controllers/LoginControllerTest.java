package br.com.concrete.teste.controllers;

import br.com.concrete.teste.helpers.JwtToken;
import br.com.concrete.teste.interfaces.UserService;
import br.com.concrete.teste.models.AuthRequest;
import br.com.concrete.teste.models.Phone;
import br.com.concrete.teste.models.User;
import br.com.concrete.teste.repositories.UserRepository;
import com.google.gson.Gson;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(LoginController.class)
@AutoConfigureTestDatabase
public class LoginControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private br.com.concrete.teste.interfaces.UserService UserService;

    @MockBean
    private JwtToken jwtToken;

    @MockBean
    private LoginController loginController;



    @Test
    public void create() throws Exception{
        User user = newUser("APP TESTE2", "EEEWE@EEE.COM","123");
        user.setPhones(newPhoneList());
        this.mvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(user)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void login() throws Exception {
        AuthRequest authRequest = new AuthRequest("EEEEW@EEE.COM","123");
        this.mvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(authRequest))
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void loginError() throws Exception {
        AuthRequest authRequest = new AuthRequest("EEEEW@EEE.COM","123w");

        this.mvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(authRequest))
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
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
