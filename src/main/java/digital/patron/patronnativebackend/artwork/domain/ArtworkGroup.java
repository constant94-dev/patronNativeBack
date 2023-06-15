package digital.patron.patronnativebackend.artwork.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter(AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
public class ArtworkGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String localization;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0", length = 1)
    private boolean status;

    @OneToMany(mappedBy = "artworkGroup")
    private Set<ArtworkArtworkGroup> artworkArtworkGroups = new HashSet<>();

    protected ArtworkGroup(){}

}
