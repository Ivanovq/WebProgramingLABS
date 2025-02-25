package mk.ukim.finki.labb1.repository.jpa;


import mk.ukim.finki.labb1.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumJPARepository extends JpaRepository<Album, Long> {
}