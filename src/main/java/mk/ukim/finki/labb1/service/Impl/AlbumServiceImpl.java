package mk.ukim.finki.labb1.service.Impl;

import mk.ukim.finki.labb1.model.Album;
import mk.ukim.finki.labb1.repository.AlbumRepository;
import mk.ukim.finki.labb1.repository.jpa.AlbumJPARepository;
import mk.ukim.finki.labb1.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumJPARepository albumRepository;

    public AlbumServiceImpl(AlbumJPARepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album findById(Long id) {
        return albumRepository.findById(id).orElse(null);
    }

}
