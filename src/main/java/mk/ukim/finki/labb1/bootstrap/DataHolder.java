package mk.ukim.finki.labb1.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.labb1.model.Album;
import mk.ukim.finki.labb1.model.Artist;
import mk.ukim.finki.labb1.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
 public static List<Artist> artist=new ArrayList<>();
 public static  List<Song> songs=new ArrayList<>();
 public static List<Album> albums=new ArrayList<>();
 @PostConstruct
 public void init()
 {

  Album album1=new Album( "Greatest Hits", "Rock", "1981");
  albums.add(album1);
  Album album2=new Album( "Classical Symphony", "Classical", "1965");
  albums.add(album2);
  Album album3=new Album( "Jazz Masters", "Jazz", "1975");
  albums.add(album3);
  Album album4=new Album("Pop Collection", "Pop", "1990");
  albums.add(album4);
  Album album5=new Album("Metal Legends", "Metal", "2001");
  albums.add(album5);

  artist.add(new Artist(678L, "Drake", "Graham", "Aubrey Drake Graham is a Canadian rapper, singer, and actor."));
  artist.add(new Artist(789L, "Katy", "Perry", "Katheryn Elizabeth Hudson, known professionally as Katy Perry, is an American singer, songwriter, and television judge."));
  artist.add(new Artist(890L, "Bruno", "Mars", "Peter Gene Hernandez, known professionally as Bruno Mars, is an American singer, songwriter, record producer, and dancer."));
  artist.add(new Artist(901L, "Shakira", "Mebarak", "Shakira Isabel Mebarak Ripoll is a Colombian singer, songwriter, and dancer."));
  artist.add(new Artist(1011L, "Lady", "Gaga", "Stefani Joanne Angelina Germanotta, known professionally as Lady Gaga, is an American singer, songwriter, and actress."));



  List<Artist> song6Artists = new ArrayList<>();
  song6Artists.add(new Artist(678L, "Drake", "Graham", "Aubrey Drake Graham is a Canadian rapper, singer, and actor."));
  song6Artists.add(new Artist(789L, "Katy", "Perry", "Katheryn Elizabeth Hudson, known professionally as Katy Perry, is an American singer, songwriter, and television judge."));
  songs.add(new Song("tdwom2016", "Too Good", "Hip-Hop/R&B", 2016, song6Artists,album3));

  List<Artist> song7Artists = new ArrayList<>();
  song7Artists.add(new Artist(890L, "Bruno", "Mars", "Peter Gene Hernandez, known professionally as Bruno Mars, is an American singer, songwriter, record producer, and dancer."));
  song7Artists.add(new Artist(789L, "Katy", "Perry", "Katheryn Elizabeth Hudson, known professionally as Katy Perry, is an American singer, songwriter, and television judge."));
  songs.add(new Song("ltkf2012", "Locked Out of Heaven", "Pop/Rock", 2012, song7Artists,album1));

  List<Artist> song8Artists = new ArrayList<>();
  song8Artists.add(new Artist(1011L, "Lady", "Gaga", "Stefani Joanne Angelina Germanotta, known professionally as Lady Gaga, is an American singer, songwriter, and actress."));
  song8Artists.add(new Artist(890L, "Bruno", "Mars", "Peter Gene Hernandez, known professionally as Bruno Mars, is an American singer, songwriter, record producer, and dancer."));
  songs.add(new Song("jappls2009", "Just Dance", "Pop", 2009, song8Artists,album2));



  List<Artist> song10Artists = new ArrayList<>();
  song10Artists.add(new Artist(1011L, "Lady", "Gaga", "Stefani Joanne Angelina Germanotta, known professionally as Lady Gaga, is an American singer, songwriter, and actress."));
  song10Artists.add(new Artist(789L, "Katy", "Perry", "Katheryn Elizabeth Hudson, known professionally as Katy Perry, is an American singer, songwriter, and television judge."));
  songs.add(new Song("rnglory2013", "Roar", "Pop", 2013, song10Artists,album3));

  List<Artist> song11Artists = new ArrayList<>();
  song11Artists.add(new Artist(678L, "Drake", "Graham", "Aubrey Drake Graham is a Canadian rapper, singer, and actor."));
  song11Artists.add(new Artist(890L, "Bruno", "Mars", "Peter Gene Hernandez, known professionally as Bruno Mars, is an American singer, songwriter, record producer, and dancer."));
  songs.add(new Song("hottlnb2018", "Hotline Bling", "Hip-Hop/R&B", 2018, song11Artists,album4));


 }

}