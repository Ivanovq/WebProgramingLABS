package mk.ukim.finki.labb1.repository;


import mk.ukim.finki.labb1.bootstrap.DataHolder;
import mk.ukim.finki.labb1.model.Album;
import mk.ukim.finki.labb1.model.Artist;
import mk.ukim.finki.labb1.model.Song;

import mk.ukim.finki.labb1.repository.jpa.AlbumJPARepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongRepository {
    private final AlbumRepository albumRepository;

    public SongRepository(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Song> findAll() {
        return DataHolder.songs;
    }


    public Song findByTrackId(String trackId) {
        return DataHolder.songs.stream()
                .filter(i -> i.getTrackId().equals(trackId))
                .findFirst().orElse(null);
    }

    public Song findById(Long id) {
        return DataHolder.songs.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst().orElse(null);
    }

    public void deleteById(Long id) {
        DataHolder.songs.removeIf(i -> i.getId().equals(id));
    }



    public Artist addArtistToSong(Artist artist, Song song) {
        Song songg = DataHolder.songs.stream()
                .filter(i -> i.equals(song))
                .findFirst().orElse(null);
        songg.getPerformers().add(artist);
        return artist;
    }

    public void save(String title, String trackId, String genre, int releaseYear, Long albumId){
        DataHolder.songs.add(new Song(title, trackId, genre, releaseYear, albumRepository.findById(albumId)));
    }


}
