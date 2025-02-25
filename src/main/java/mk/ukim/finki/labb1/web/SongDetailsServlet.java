package mk.ukim.finki.labb1.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.labb1.model.Artist;
import mk.ukim.finki.labb1.model.Song;
import mk.ukim.finki.labb1.service.ArtistService;
import mk.ukim.finki.labb1.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "songDetailsServlet",urlPatterns = "/servlet/songDetails")
public class SongDetailsServlet extends HttpServlet {
    private final SongService songService;
    private final ArtistService artistService;
    private final SpringTemplateEngine springTemplateEngine;

    public SongDetailsServlet(SongService songService, ArtistService artistService, SpringTemplateEngine springTemplateEngine) {
        this.songService = songService;
        this.artistService = artistService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange= JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context=new WebContext(webExchange);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange= JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context=new WebContext(webExchange);
        String trackId=req.getParameter("trackId");
        Song song= songService.findByTrackId(trackId);
        //Double avgRating=songService.averageRating(song);
        Long artistId=Long.valueOf(req.getParameter("artistId"));
        Artist artist=artistService.ArtistfindById(artistId);
        List<Artist> artists=new ArrayList<>();
        artists=song.getPerformers();
        artists.add(artist);


        context.setVariable("songTitle",song.getTitle());
        context.setVariable("songGenre",song.getGenre());
        context.setVariable("songYear",song.getReleaseYear());
        context.setVariable("songArtistsList",artists);
        //context.setVariable("avgRating",avgRating);




        springTemplateEngine.process("songDetails.html",context,resp.getWriter());
    }
}
