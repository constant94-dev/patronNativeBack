package digital.patron.patronnativebackend.artwork.domain;

import digital.patron.patronnativebackend.artist.domain.Artist;
import digital.patron.patronnativebackend.integrate.domain.ArtworkExhibition;
import digital.patron.patronnativebackend.member.domain.MemberLikedArtwork;
import digital.patron.patronnativebackend.member.domain.MemberSeenArtwork;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class Artwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String code;

    @Column(nullable = false, length = 100)
    private String localization;

    @Column(nullable = false, length = 100)
    private String size;

    @Column(nullable = false, length = 100)
    private String year;

    @Column(nullable = true, length = 100)
    private String belong;

    @Column(nullable = false, columnDefinition = "TINYINT DEFAULT 0", length = 1)
    private Boolean nft_regist;

    @Column(nullable = false, columnDefinition = "TINYINT DEFAULT 0", length = 1)
    private Boolean approve;

    @Column(nullable = false, columnDefinition = "TINYINT DEFAULT 0", length = 1)
    private Boolean charge_free;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer numberOfLikes;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer numberOfViews;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer numberOfShares;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer views_excluding_this_month;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer durationTime;

    @Column(nullable = false, name = "showingUpdateTime", columnDefinition = "TIMESTAMP DEFAULT CURRENT_DATETIME")
    private LocalDateTime localizationUpdateTime;

    @Column(nullable = true, length = 500)
    private String shopUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sound sound;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Contents4k contents_4k;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ContentsHd contentsHd;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ContentsThumbnail contentsThumbnail;

    @OneToMany(mappedBy = "artwork")
    private Set<ArtworkDetail> artworkDetails = new HashSet<>();

    @OneToMany(mappedBy = "artwork")
    private Set<MemberLikedArtwork> memberLikedArtworks = new HashSet<>();

    @OneToMany(mappedBy = "artwork")
    private Set<MemberSeenArtwork> memberSeenArtworks = new HashSet<>();

    @OneToMany(mappedBy = "artwork")
    private Set<ArtworkExhibition> artworkExhibitions = new HashSet<>();

    @OneToMany(mappedBy = "artwork")
    private Set<ArtworkArtworkTag> artworkArtworkTags = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Artist artist;

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setContents4k(Contents4k contents4k) {
        this.contents_4k = contents4k;
    }

    public void setContentsHd(ContentsHd contentsHd) {
        this.contentsHd = contentsHd;
    }

    public void setContentsThumbnail(ContentsThumbnail contentsThumbnail) {
        this.contentsThumbnail = contentsThumbnail;
    }

    protected Artwork() {}
}