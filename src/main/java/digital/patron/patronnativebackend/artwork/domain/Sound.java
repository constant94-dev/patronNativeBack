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
public class Sound {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String code;

    @Column(nullable = false, length = 50)
    private String type;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 100)
    private String creator;

    @Column(nullable = false, length = 100)
    private String player;

    @Column(nullable = false, length = 300)
    private String origin_url;

    @Column(nullable = false, length = 100)
    private String license;

    @Column(nullable = false, length = 300)
    private String url;

    @OneToMany(mappedBy = "sound")
    private Set<SoundSoundTag> soundSoundTagSet = new HashSet<>();

    @OneToMany(mappedBy = "sound")
    private Set<Artwork> artworks = new HashSet<>();

    public void addArtwork(Artwork artwork){
        artworks.add(artwork);
        artwork.setSound(this);
    }

    protected Sound(){}
}
