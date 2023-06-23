package digital.patron.patronnativebackend.artist.domain;

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
public class ArtistGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String localization;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 1)
    private Boolean status;

    @OneToMany(mappedBy = "artistGroup")
    private Set<ArtistArtistGroup> artistArtistGroups = new HashSet<>();

    protected ArtistGroup(){}
}
