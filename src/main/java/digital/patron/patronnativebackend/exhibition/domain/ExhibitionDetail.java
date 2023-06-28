package digital.patron.patronnativebackend.exhibition.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class ExhibitionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 10)
    private String language;

    @Column(nullable = false, length = 5000)
    private String intro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exhibition_id")
    private Exhibition exhibition;

    public void setExhibition(Exhibition exhibition) {
        this.exhibition = exhibition;
    }

    public ExhibitionDetail(String language, String name, String intro) {
        this.language = language;
        this.name = name;
        this.intro = intro;
    }

    public static ExhibitionDetail createDefault() {
        return new ExhibitionDetail();
    }

    protected ExhibitionDetail() {
    }
}
