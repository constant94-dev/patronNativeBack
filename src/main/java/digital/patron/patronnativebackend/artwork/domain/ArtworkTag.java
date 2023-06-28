package digital.patron.patronnativebackend.artwork.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class ArtworkTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String language;

    @OneToMany(mappedBy = "artworkTag")
    private Set<ArtworkArtworkTag> artworkArtworkTags = new HashSet<>();

    public ArtworkTag(String tagName, String language){
        this.name = tagName;
        this.language = language;
    }

    protected ArtworkTag(){}
}
