package com.example.bulletinboardapp.Service;

import com.example.bulletinboardapp.Model.Announcement;

import com.example.bulletinboardapp.Repository.AnnouncementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@EnableCaching
public class AnnouncemenetService {


    private final AnnouncementRepository announcementRepository;

    @Cacheable(cacheNames = "Ads")
    public List<Announcement> getAllAnnouncements(){
        return announcementRepository.findAll();
    }

    @Cacheable(cacheNames = "SingleAd ", key ="#id")
    public Announcement getSingleAnnouncement(long id){
        return announcementRepository.findById(id).orElseThrow();
    }


    public void deleteById(long id){
         announcementRepository.deleteById(id);
    }

    @Cacheable(cacheNames = "Ads")
    public List<Announcement> getVehicles(){
        return announcementRepository.findAllVehicleAnnoucements();
    }

    @Cacheable(cacheNames = "Ads")
    public List<Announcement> getMusic(){
        return announcementRepository.findAllMusicAnnoucements();
    }

    @Cacheable(cacheNames = "Ads")
    public List<Announcement> getClothes(){
        return announcementRepository.findAllClothesAnnoucements();
    }

    @Cacheable(cacheNames = "Ads")
    public List<Announcement> getMovies() {
        return announcementRepository.findAllMoviesAnnoucements();
    }

    public Announcement saveAnnouncement(Announcement newAd){
        return announcementRepository.save(newAd);
    }


    @Transactional
    public Announcement updateAnnouncement(Announcement announcement){
        Announcement editedAd= announcementRepository.findById(announcement.getId()).orElseThrow();
        editedAd.setTitle(announcement.getTitle());
        editedAd.setContent(announcement.getContent());
        editedAd.setType(announcement.getType());
        return editedAd;
    }
}
