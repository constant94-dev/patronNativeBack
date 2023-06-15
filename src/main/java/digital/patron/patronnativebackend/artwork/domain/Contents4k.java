package digital.patron.patronnativebackend.artwork.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "contents_4k")
public class Contents4k {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String code;

    @Column(nullable = true, length = 500)
    private String video;

    @Column(nullable = false, length = 500)
    private String default_img;

    @Column(nullable = false, length = 500)
    private String original_img;

    public Contents4k(String code, String video, String defaultImg, String originalImg) {
        this.code = code;
        this.video = video;
        this.default_img = defaultImg;
        this.original_img = originalImg;
    }

    protected Contents4k(){}
}
