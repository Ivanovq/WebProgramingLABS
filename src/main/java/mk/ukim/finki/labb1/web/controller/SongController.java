package mk.ukim.finki.labb1.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.labb1.model.Album;
import mk.ukim.finki.labb1.model.Song;
import mk.ukim.finki.labb1.service.AlbumService;
import mk.ukim.finki.labb1.service.SongService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }


    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model, HttpServletRequest req){
        List<Song> songs = songService.listSongs();
        model.addAttribute("songs", songs);


        List<Song> songs1 = new ArrayList<>();
        String album = req.getParameter("albumId1");
        if (album != null) {
            if (!album.isEmpty()) {
                songs1 = songService.listSongs().stream()
                        .filter(s -> Long.toString(s.getAlbum().getId()).equals(req.getParameter("albumId1")))
                        .collect(Collectors.toList());
            }
        }

        List<Album> albums = albumService.findAll();
        model.addAttribute("songs1", songs1);
        model.addAttribute("albums", albums);


        return "listSongs";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public String saveSong(@RequestParam String title,
                           @RequestParam String trackId,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam(required = false) Long id,
                           @RequestParam Long albumId,
                           Model model
    ){

        if(id == 0){
            this.songService.saveSong(title, trackId, genre, releaseYear, albumId);
            return "redirect:/songs";
        }

        Song song = this.songService.findById(id);
        song.setTitle(title);
        song.setTrackId(trackId);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(albumService.findById(albumId));
        model.addAttribute("trackId", trackId);

        this.songService.saveSong(song.getTitle(), song.getTrackId(), song.getGenre(), song.getReleaseYear(), song.getAlbum().getId());

        return "redirect:/songs";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit/{songId}")
    public String editSong(@PathVariable Long songId,
                           @RequestParam String title,
                           @RequestParam String trackId,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam Long album,
                           Model model
    ){
        Song song = this.songService.findById(songId);

        song.setTitle(title);
        song.setTrackId(trackId);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(albumService.findById(album));
        model.addAttribute("trackId", trackId);


        return "redirect:/songs";
    }



    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        songService.deleteById(id);
        return "redirect:/songs";
    }



    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/edit-form/{id}")
    public String getEditSongForm(@PathVariable Long id, Model model){
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        List<Album> albums = albumService.findAll();
        model.addAttribute("albums", albums);
        model.addAttribute("trackId", song.getTrackId());

        return "add-song";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/add-form")
    public String getAddSongPage(Model model){
        List<Album> albums = albumService.findAll();
        model.addAttribute("albums", albums);
        return "add-song";
    }
}
