package com.example.bulletinboardapp.Repository;

import com.example.bulletinboardapp.Model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {
     String query="SELECT * FROM annoucements WHERE type=";

    @Query( nativeQuery = true,
           value = query+"'Vehicles' ")
     List<Announcement> findAllVehicleAnnoucements();

    @Query( nativeQuery = true,
            value = query+ "'Music' ")
    List<Announcement> findAllMusicAnnoucements();

    @Query( nativeQuery = true,
            value = query +"'Clothes' ")
    List<Announcement> findAllClothesAnnoucements();


    @Query( nativeQuery = true,
            value = query +"'Movies' ")
    List<Announcement> findAllMoviesAnnoucements();
}
