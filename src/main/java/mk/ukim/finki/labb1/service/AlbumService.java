package mk.ukim.finki.labb1.service;


import mk.ukim.finki.labb1.model.Album;

import java.util.List;


public interface AlbumService {
    List<Album> findAll();

    Album findById(Long albumId);
}
