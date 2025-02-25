package mk.ukim.finki.labb1.repository;

import mk.ukim.finki.labb1.bootstrap.DataHolder;
import mk.ukim.finki.labb1.model.Album;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepository {

        public List<Album> findAll() {
            return DataHolder.albums;
        }
    public Album findById(Long id) {
        return DataHolder.albums.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst().orElse(null);
    }

}
