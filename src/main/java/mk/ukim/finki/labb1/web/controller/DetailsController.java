package mk.ukim.finki.labb1.web.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.labb1.model.Artist;
import mk.ukim.finki.labb1.model.Song;
import mk.ukim.finki.labb1.service.AlbumService;
import mk.ukim.finki.labb1.service.ArtistService;
import mk.ukim.finki.labb1.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/songDetails",method = RequestMethod.POST)
public class DetailsController {
    private final SongService songService;
    private final ArtistService artistService;
    private final AlbumService albumService;


    public DetailsController(SongService songService, ArtistService artistService, SpringTemplateEngine springTemplateEngine, AlbumService albumService) {
        this.songService = songService;
        this.artistService = artistService;
        this.albumService = albumService;
    }


    @PostMapping
    protected String showSongDetails(HttpServletRequest req, HttpServletResponse resp, Model model) throws ServletException, IOException {
        String trackId = req.getParameter("trackId");
        Song song = songService.findByTrackId(trackId);

        Long artistId = Long.valueOf(req.getParameter("artistId"));
        Artist artist = artistService.ArtistfindById(artistId);

        List<Artist> artists = new ArrayList<>();
        artists = song.getPerformers();
        artists.add(artist);

        model.addAttribute("songTitle", song.getTitle());
        model.addAttribute("songGenre", song.getGenre());
        model.addAttribute("songYear", song.getReleaseYear());
        model.addAttribute("songArtistsList", artists);


        return "songDetails";
    }
}
