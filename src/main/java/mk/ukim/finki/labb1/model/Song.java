package mk.ukim.finki.labb1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматско генерирање на уникатен id
    private Long id;

    private String trackId;

    private String title;

    private String genre;

    private int releaseYear;

    @ManyToMany
    private List<Artist> performers = new ArrayList<>();

    @ManyToOne
    private Album album;

    // Конструктор со сите полиња
    public Song(String trackId, String title, String genre, int releaseYear, List<Artist> performers, Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
    }

    // Конструктор без листа на изведувачи
    public Song(String trackId, String title, String genre, int releaseYear, Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.album = album;
    }

    public Song(String trackId, String title,  String genre, int releaseYear) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
}
