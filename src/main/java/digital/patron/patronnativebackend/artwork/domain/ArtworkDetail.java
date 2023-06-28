package digital.patron.patronnativebackend.artwork.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class ArtworkDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2)
    private String language;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 5000)
    private String intro;

    @Column(nullable = false, length = 100)
    private String category;

    @Column(nullable = false, length = 500)
    private String source;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artwork_id")
    private Artwork artwork;

    public ArtworkDetail(String language, String artworkName, String intro, String category, String source) {
        this.language = language;
        this.name = artworkName;
        this.intro = intro;
        this.category = category;
        this.source = source;
    }

    public static ArtworkDetail createDefault() {
        return new ArtworkDetail();
    }

    protected ArtworkDetail() {
    }
}
