package digital.patron.patronnativebackend.artwork.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
public class ContentsThumbnail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String code;

    @Column(nullable = false, length = 500)
    private String video;

    @Column(nullable = false, length = 500)
    private String defaultImg;

    @Column(nullable = false, length = 500)
    private String originalImg;

    public ContentsThumbnail(String code, String video, String defaultImg, String originalImg){
        this.code = code;
        this.video = video;
        this.defaultImg = defaultImg;
        this.originalImg = originalImg;
    }

    protected ContentsThumbnail(){}
}
