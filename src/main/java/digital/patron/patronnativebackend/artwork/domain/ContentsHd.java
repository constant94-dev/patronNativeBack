package digital.patron.patronnativebackend.artwork.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class ContentsHd {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String code;

    @Column(nullable = false, length = 500)
    private String video;

    @Column(nullable = false, length = 500)
    private String defaultImg;

    @Column(nullable = false, length = 500)
    private String originalImg;

    public ContentsHd(String code, String video, String defaultImg, String originalImg) {
        this.code = code;
        this.video = video;
        this.defaultImg = defaultImg;
        this.originalImg = originalImg;
    }

    protected ContentsHd() {}
}
