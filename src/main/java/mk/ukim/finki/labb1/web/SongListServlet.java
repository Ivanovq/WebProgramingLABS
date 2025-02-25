package mk.ukim.finki.labb1.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.labb1.model.Song;
import mk.ukim.finki.labb1.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "songListServlet",urlPatterns = "/servlet/listSongs")
public class SongListServlet extends HttpServlet {
    public final SongService songService;
    public final SpringTemplateEngine springTemplateEngine;

    public SongListServlet(SongService songService, SpringTemplateEngine springTemplateEngine) {
        this.songService = songService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange= JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req,resp);
        WebContext context = new WebContext(webExchange);

        List<Song> songs=new ArrayList<>();
        songs=songService.listSongs();
        context.setVariable("songs",songs);
        springTemplateEngine.process("listSongs.html",context,resp.getWriter());

    }

}
