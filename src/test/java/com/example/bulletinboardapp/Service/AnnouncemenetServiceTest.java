package com.example.bulletinboardapp.Service;

import com.example.bulletinboardapp.Model.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class AnnouncemenetServiceTest {

    @Autowired
    private AnnouncemenetService announcemenetService;

   private void shouldGetSingleAd(){
        //given
        //when
        Announcement announcement=announcemenetService.getSingleAnnouncement(1L);
        //then
    assertThat(announcement).isNotNull();
    assertThat(announcement).isEqualTo(1L);

    }

}