package mk.ukim.finki.labb1.repository;

import mk.ukim.finki.labb1.bootstrap.DataHolder;
import mk.ukim.finki.labb1.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {
    public List<Artist> findAll()
    {
        return DataHolder.artist;
    }
    public Optional<Artist> findById(Long id){
        return  DataHolder.artist.stream().filter(i->i.getId().equals(id)).findFirst();

    }
}
