package team.area237.lmlys;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import team.area237.lmlys.controller.LoginController;
import team.area237.lmlys.controller.RegisterController;
import team.area237.lmlys.model.request.LoginRequest;
import team.area237.lmlys.model.request.RegisterRequest;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoginRegisterMockTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    LoginController loginController;
    @Autowired
    RegisterController registerController;

    private MockMvc loginMockMvc;
    private MockMvc registerMockMvc;
    private MockMvc mockMvc;

    @Before
    public void init() {
//        loginMockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
//        registerMockMvc = MockMvcBuilders.standaloneSetup(registerController).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void loginTest() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("password", "123456");
        map.put("username", "testName");
        mockMvc.perform(post("/login")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(JSON.toJSONString(map)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void registerTest() throws Exception {
        mockMvc.perform(get("/exist/username")
        .param("username", "testName")
        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andDo(print());
    }
}
