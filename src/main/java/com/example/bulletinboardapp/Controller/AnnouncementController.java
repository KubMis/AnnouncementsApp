package com.example.bulletinboardapp.Controller;

import com.example.bulletinboardapp.Model.Announcement;
import com.example.bulletinboardapp.Service.AnnouncemenetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class AnnouncementController {

    private final AnnouncemenetService announcemenetService;

    @GetMapping("/ads")
    public List<Announcement> getAllAnnouncements() {
        return announcemenetService.getAllAnnouncements();
    }

    @GetMapping("/ads/{id}")
    public Announcement getSingleAnnouncement(@PathVariable long id) {
        return announcemenetService.getSingleAnnouncement(id);
    }

    @DeleteMapping("ads/{id}")
    public void  deleteAnnouncementById(@PathVariable long id){
        announcemenetService.deleteById(id);
    }

    @PostMapping("/ads")
    public Announcement createAnnouncement(@RequestBody Announcement announcement){
        return announcemenetService.saveAnnouncement(announcement);
    }


   @GetMapping("/ads/Vehicles")
        public List<Announcement> getAllVehiclesAnnouncements(){
          return   announcemenetService.getVehicles();
    }


    @GetMapping("/ads/Music")
    public List<Announcement> getAllMusicAnnouncements(){
        return   announcemenetService.getMusic();
    }


    @GetMapping("/ads/Clothes")
    public List<Announcement> getAllClothesAnnouncements(){
        return   announcemenetService.getClothes();
    }


    @GetMapping("/ads/Movies")
    public List<Announcement> getAllMoviesAnnouncements(){
        return   announcemenetService.getMovies();
    }


    @PutMapping("/ads")
    public Announcement  updateAnnouncement(@RequestBody Announcement announcement){
       return announcemenetService.updateAnnouncement(announcement);
    }





}
