package digital.patron.patronnativebackend.integrate.domain;

import digital.patron.patronnativebackend.artwork.domain.Artwork;
import digital.patron.patronnativebackend.exhibition.domain.Exhibition;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "artwork_exhibition_relation")
public class ArtworkExhibition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artwork artwork;

    @ManyToOne(fetch = FetchType.LAZY)
    private Exhibition exhibition;

    public void setArtwork(Artwork artwork) {
        this.artwork = artwork;
    }

    public void setExhibition(Exhibition exhibition) {
        this.exhibition = exhibition;
    }
}
