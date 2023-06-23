package digital.patron.patronnativebackend.artist.domain;

import digital.patron.patronnativebackend.artwork.domain.Artwork;
import digital.patron.patronnativebackend.integrate.domain.ArtistExhibition;
import digital.patron.patronnativebackend.member.domain.MemberLikedArtist;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String code;

    @Column(nullable = false, length = 100)
    private String localization;

    @Column(nullable = false, length = 500)
    private String profileImg;

    @Column(nullable = false, length = 500)
    private String resume;

    @Column(nullable = false, length = 500)
    private String video;

    @Column(nullable = false, length = 1)
    private Boolean approve;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer numberOfLikes;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer numberOfShares;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_DATETIME")
    private LocalDate birth;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_DATE")
    private LocalDate deathDate;

    @Column(nullable = false, length = 1)
    private Boolean deathCheck;

    @OneToMany(mappedBy = "artist")
    @OrderBy("id asc")
    private Set<Artwork> artworks = new HashSet<>();

    @OneToMany(mappedBy = "artist")
    private Set<ArtistExhibition> artistExhibitions = new HashSet<>();

    @OneToMany(mappedBy = "artist")
    private Set<ArtistArtistGroup> artistArtistGroups = new HashSet<>();

    @OneToMany(mappedBy = "artist")
    private Set<ArtistArtistTag> artistArtistTags = new HashSet<>();

    @OneToMany(mappedBy = "artist")
    private Set<MemberLikedArtist> memberLikedArtists = new HashSet<>();

    @OneToMany(mappedBy = "artist")
    private Set<ArtistDetail> artistDetails = new HashSet<>();

    public Artist(
            String code, String localization, String profileImg, String resume,
            LocalDate birth, LocalDate deathDate, Boolean deathCheck, Boolean approve,
            Integer numberOfLikes, Integer numberOfShares) {
        this.code = code;
        this.localization = localization;
        this.profileImg = profileImg;
        this.resume = resume;
        this.birth = birth;
        this.deathDate = deathDate;
        this.deathCheck = deathCheck;
        this.approve = approve;
        this.numberOfLikes = numberOfLikes;
        this.numberOfShares = numberOfShares;
    }

    public void increaseNumberOfLikes() {
        this.numberOfLikes += 1;
    }

    public void increaseNumberOfShares() {
        this.numberOfShares += 1;
    }

    public void decreaseNumberOfLikes() {
        if (this.numberOfLikes > 0) {
            this.numberOfLikes -= 1;
        }
    }

    public void addArtwork(Artwork artwork){
        artworks.add(artwork);
        artwork.setArtist(this);
    }

    protected Artist() {}
}
