package com.example.bulletinboardapp.controller;


import com.example.bulletinboardapp.Model.Announcement;
import com.example.bulletinboardapp.Repository.AnnouncementRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
 class AnnouncementControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Test
    @Transactional
    void shouldGetSingleAnnouncement() throws Exception {
        //given
        Announcement newAnnouncement=new Announcement();
        newAnnouncement.setId(1L);
        newAnnouncement.setTitle("test");
        newAnnouncement.setContent("testContent");
        newAnnouncement.setType("Vehicles");
        announcementRepository.save(newAnnouncement);
        //when
       MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders.get("/ads/"+newAnnouncement.getId()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
        //then
      Announcement announcement=  objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Announcement.class);
        assertThat(announcement).isNotNull();
        assertThat(announcement.getId()).isEqualTo(newAnnouncement.getId());
        assertThat(announcement.getTitle()).isEqualTo("test");
        assertThat(announcement.getContent()).isEqualTo(newAnnouncement.getContent());
        assertThat(announcement.getType()).isEqualTo("Vehicles");

    }
}
