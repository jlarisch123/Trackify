package trackify.core;

import org.eclipse.jetty.util.annotation.Name;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "albums")
@NamedQueries({
        @NamedQuery(name = "Album.findByUserId", query = "SELECT a FROM Album a WHERE a.user_id = :userId")
})
public class Album {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "artist")
    private String artist;

    //private List<Image> image;

    @Column(name = "user_id")

    private int user_id;

    @Column(name = "release_year")
    private int releaseYear;


    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /*public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }*/

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int userId) {
        this.user_id = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
