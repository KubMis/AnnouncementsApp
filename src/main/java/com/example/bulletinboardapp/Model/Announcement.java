package com.example.bulletinboardapp.Model;

import lombok.Data;



import javax.persistence.*;


@Entity(name = "annoucements")
@Data
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    private String type;
}
