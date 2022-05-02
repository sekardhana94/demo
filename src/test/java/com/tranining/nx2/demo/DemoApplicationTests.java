package com.tranining.nx2.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import com.tranining.nx2.controller.DemoController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@ExtendWith(SpringExtension.class)
@WebMvcTest(value = DemoController.class)
class DemoApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    DemoController demoController;
//
//    @Test
//    void invalidApiTest() throws Exception {
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//            "/demo/hellos").accept(
//            MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        Assertions.assertThat(result.getResponse().getStatus()).isEqualTo(404);
//        Assertions.assertThat(result.getResponse().getContentAsString()).isEqualTo("");
//    }
//
//    @Test
//    void successTestDemo() throws Exception {
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//            "/demo/hello").accept(
//            MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        Assertions.assertThat(result.getResponse()).isNotNull();
//        Assertions.assertThat(result.getResponse().getContentAsString()).isEqualTo("Hello-World");
//    }
//
//    @Test
//    void successTestMemberList() {
//        try {
//            ClassLoader loader = ClassLoader.getSystemClassLoader();
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(
//                loader.getResourceAsStream("teamList.json"), "UTF-8"
//            ));
//
//            RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//                "/demo/teamList").accept(
//                MediaType.APPLICATION_JSON);
//
//            MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//            Assertions.assertThat(result.getResponse()).isNotNull();
//            Assertions.assertThat(result.getResponse().getContentAsString()).isEqualTo(in.lines().collect(Collectors.joining()));
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.err.println("Was not able to load the JSON string.");
//        }
//
//    }

}
