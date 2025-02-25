package mk.ukim.finki.labb1.web.controller;

import jakarta.servlet.http.HttpServletRequest;

import mk.ukim.finki.labb1.model.Artist;
import mk.ukim.finki.labb1.model.Song;
import mk.ukim.finki.labb1.service.ArtistService;
import mk.ukim.finki.labb1.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping(value = "/artists", method = RequestMethod.POST)
public class ArtistController {

    private final SongService songService;

    private final ArtistService artistService;

    public ArtistController(SongService songService, ArtistService artistService) {
        this.songService = songService;
        this.artistService = artistService;
    }

    @PostMapping
    public String artistsShowing(Model model, HttpServletRequest req) {
        String trackId = req.getParameter("trackId");
        System.out.println("Received trackId: " + trackId);

        List<Artist> artists = artistService.listArtists();
        model.addAttribute("trackId", trackId);
        model.addAttribute("artists", artists);

        return "artistsList";
    }



}



