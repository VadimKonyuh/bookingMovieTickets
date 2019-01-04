package dao.hibernate;

import com.konyuh.utils.JPAUtility;
import com.konyuh.entity.Genre;
import com.konyuh.entity.Movie;
import org.junit.Test;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


public class GenreDAOTest {

   @Test
    public void create(){
       Genre genre = new Genre();
       genre.setName("Test");
       EntityManager entityManager = JPAUtility.getEntityManager();
       entityManager.persist(genre);
   }

   @Test
   public void read(){
       EntityManager entityManager = JPAUtility.getEntityManager();
       entityManager.find(Genre.class, 1);
   }

   @Test
   public void update(){
      EntityManager entityManager = JPAUtility.getEntityManager();
      Genre genre = new Genre();
      genre.setName("Test");
      entityManager.merge(genre);
   }

   @Test
   public void delete(){
      EntityManager entityManager = JPAUtility.getEntityManager();
      Genre genre = entityManager.find(Genre.class, 2);
      entityManager.remove(genre);
   }

   @Test
   public void listTest(){
      EntityManager entityManager = JPAUtility.getEntityManager();
      Genre genre = new Genre();
      Movie movie = new Movie();
      Movie movie1 = new Movie();
      movie.setTitle("Test");
      movie1.setTitle("Test1");
      List<Movie> movieList = new ArrayList<>();
      movieList.add(movie);
      movieList.add(movie1);
      genre.setName("test");
      genre.setMovies(movieList);
      entityManager.persist(genre);
   }
}
