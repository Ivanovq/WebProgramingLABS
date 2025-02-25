package mk.ukim.finki.labb1.repository.jpa;


import mk.ukim.finki.labb1.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface SongJPARepository extends JpaRepository<Song, Long> {
    @Query("SELECT s FROM Song s WHERE s.album.id = :value")

    public List<Song> findAllByAlbum_Id(@Param("value") Long id);
    public Song findByTrackId(String trackId);

}
