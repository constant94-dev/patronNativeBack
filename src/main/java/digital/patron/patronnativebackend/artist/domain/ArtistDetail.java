package digital.patron.patronnativebackend.artist.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class ArtistDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String language;

    private String name;

    private String intro;

    private String nationality;

    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public ArtistDetail(String language, String artistName, String intro, String nationality, String gender) {
        this.language = language;
        this.name = artistName;
        this.intro = intro;
        this.nationality = nationality;
        this.gender = gender;
    }

    protected ArtistDetail(){}
}
