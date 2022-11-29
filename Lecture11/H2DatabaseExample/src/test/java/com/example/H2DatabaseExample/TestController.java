package com.example.H2DatabaseExample;

import com.example.H2DatabaseExample.beans.Avenger;
import com.example.H2DatabaseExample.database.DatabaseAccess;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TestController {
    private DatabaseAccess da;
    private MockMvc mockMvc;

    @Autowired
    public void setDa(DatabaseAccess da){
        this.da=da;
    }

    @Autowired
    public void setMockMvc(MockMvc mockMvc){
        this.mockMvc = mockMvc;
    }

    @Test
    public void testRoot() throws Exception{

        //minics loading page and expect that status to be ok =and expects what the view goes to
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void testUpdateAvenger() throws Exception{

        List<Avenger> avengers = da.getAvengers();

        Avenger avenger = avengers.get(0);
        Long id = avenger.getId();;
        avenger.setName("Star-Lord");

        mockMvc.perform(post("/updateAvenger")
                .flashAttr("avenger", avenger))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/"));

        avenger = da.getAvenger(id);

        assertEquals(avenger.getName(), "Star-Lord");

    }


    @Test
    public void testAddAvenger() throws Exception {

        LinkedMultiValueMap<String,String> requestParams = new LinkedMultiValueMap<>();

        requestParams.add("name", "Gamora");
        requestParams.add("age", "26");

        int origSize = da.getAvengers().size();

        mockMvc.perform(post("/addAvenger")
                .params(requestParams))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/"));


        int newSize = da.getAvengers().size();

        assertEquals(newSize, origSize +1);
    }

    @Test
    public void testDeleteAvenger() throws Exception {

        List<Avenger> avengers = da.getAvengers();

        int origSize = avengers.size();

        Avenger avenger = avengers.get(0);
        Long id = avenger.getId();

        mockMvc.perform(MockMvcRequestBuilders.get("/deleteAvenger/{id}", id))
                .andExpect((status().isFound()))
                .andExpect(redirectedUrl("/"));

        int newSize = da.getAvengers().size();

        assertEquals(newSize, origSize - 1);

    }


}
