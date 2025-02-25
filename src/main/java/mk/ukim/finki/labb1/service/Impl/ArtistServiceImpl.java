package mk.ukim.finki.labb1.service.Impl;

import mk.ukim.finki.labb1.model.Artist;

import mk.ukim.finki.labb1.repository.ArtistRepository;
import mk.ukim.finki.labb1.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    public final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist ArtistfindById(Long id) {
         return artistRepository.findById(id).orElse(null);
    }
}
