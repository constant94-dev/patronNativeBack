package digital.patron.patronnativebackend.integrate.domain;

import digital.patron.patronnativebackend.artist.domain.Artist;
import digital.patron.patronnativebackend.exhibition.domain.Exhibition;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "artist_exhibition_relation")
public class ArtistExhibition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    private Artist artist;

    @ManyToOne(fetch = FetchType.LAZY)
    private Exhibition exhibition;

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setExhibition(Exhibition exhibition) {
        this.exhibition = exhibition;
    }
}
