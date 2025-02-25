package mk.ukim.finki.labb1.service.Impl;

import mk.ukim.finki.labb1.model.Album;
import mk.ukim.finki.labb1.model.Artist;
import mk.ukim.finki.labb1.model.Song;
import mk.ukim.finki.labb1.repository.jpa.AlbumJPARepository;
import mk.ukim.finki.labb1.repository.jpa.SongJPARepository;
import mk.ukim.finki.labb1.service.SongService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private final SongJPARepository songRepository;
    private final AlbumJPARepository albumRepository;

    public SongServiceImpl(SongJPARepository songRepository, AlbumJPARepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        songRepository.deleteById(id);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public List<Song> findAllByAlbum_Id(Long albumId) {
        return songRepository.findAllByAlbum_Id(albumId);
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        song.getPerformers().add(artist);
        songRepository.save(song);
        return artist;
    }



    @Override
    public Song saveSong(String title, String trackId, String genre, int releaseYear, Long albumId) {
        Album album = albumRepository.findById(albumId).orElse(null);
        Song song = new Song(trackId, title, genre, releaseYear, album);
        return songRepository.save(song);
    }

}
