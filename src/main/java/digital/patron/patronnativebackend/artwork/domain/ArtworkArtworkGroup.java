package digital.patron.patronnativebackend.artwork.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "artwork_artwork_group_relation")
public class ArtworkArtworkGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artwork artwork;

    @ManyToOne(fetch = FetchType.LAZY)
    private ArtworkGroup artworkGroup;

    public void setArtwork(Artwork artwork) {
        this.artwork = artwork;
    }

    public void setArtworkGroup(ArtworkGroup artworkGroup) {
        this.artworkGroup = artworkGroup;
    }
}
