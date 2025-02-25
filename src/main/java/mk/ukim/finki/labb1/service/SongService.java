package mk.ukim.finki.labb1.service;

import mk.ukim.finki.labb1.model.Album;
import mk.ukim.finki.labb1.model.Artist;
import mk.ukim.finki.labb1.model.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();

    Artist addArtistToSong(Artist artist, Song song);

    public Song findByTrackId(String trackId);

    public Song findById(Long id);

    public void deleteById(Long id);
    public List<Song> findAllByAlbum_Id(Long albumId);

    public Song saveSong(String trackId, String title, String genre, int releaseYear, Long albumId);
}


