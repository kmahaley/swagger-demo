package com.learn.controller;

import com.learn.service.CalculatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Testing with complete spring application context but without starting it on any server
 * This will call url with action(get/post) and expect the actual value return from the call
 *
 * just injecting mock dependency (eg services)
 *
 * @author km185223
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerWebMVCMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService mockCalculatorService;

    @Test
    public void testHelloControllerAdditionWithMock() throws Exception {
        Mockito.when(mockCalculatorService.add(anyInt(),anyInt())).thenReturn(500);

        this.mockMvc.perform(get("/hello/add/2/5")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("500")));
    }
}
