package br.com.concrete.teste.controllers;

import br.com.concrete.teste.helpers.JwtToken;
import br.com.concrete.teste.interfaces.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoginController.class)
@AutoConfigureTestDatabase
public class ProfileControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private br.com.concrete.teste.interfaces.UserService UserService;

    @MockBean
    private JwtToken jwtToken;

    @MockBean
    private LoginService loginService;

    @MockBean
    private ProfileController profileController;

    @Test
    public void viewProfileErroAuth() throws Exception{
        this.mvc.perform(get("/profile/2222"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
