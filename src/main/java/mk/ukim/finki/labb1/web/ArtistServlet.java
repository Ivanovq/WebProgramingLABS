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
import java.util.List;

@WebServlet(name = "artistServlet",urlPatterns = "/servlet/artist")
public class ArtistServlet extends HttpServlet {

public final ArtistService artistService;
public final SpringTemplateEngine springTemplateEngine;
public final SongService songService;

    public ArtistServlet(ArtistService artistService, SpringTemplateEngine springTemplateEngine, SongService songService) {
        this.artistService = artistService;
        this.springTemplateEngine = springTemplateEngine;
        this.songService = songService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange= JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context=new WebContext(webExchange);

        springTemplateEngine.process("artistsList.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trackId=req.getParameter("trackId");
        Song song= songService.findByTrackId(trackId);
        List<Artist> artists=artistService.listArtists();
        Double novRating= Double.valueOf(req.getParameter("rating"));
        //song.getRatings().add(novRating);
        //Double avgRating=songService.averageRating(song);
        req.setAttribute("artists",artists);
        IWebExchange webExchange=JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context=new WebContext(webExchange);
        context.setVariable("trackId",trackId);
        context.setVariable("artists",artists);
        //context.setVariable("avgRating",avgRating);
        springTemplateEngine.process("artistsList.html",context,resp.getWriter());

        //resp.sendRedirect("/servlet/songDetails");

    }
}
