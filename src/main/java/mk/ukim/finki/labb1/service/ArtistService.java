package mk.ukim.finki.labb1.service;

import mk.ukim.finki.labb1.model.Artist;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArtistService {
    List<Artist> listArtists();
    Artist ArtistfindById(Long id);

}
