package digital.patron.patronnativebackend.exhibition.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "exhibition_exhibition_group_relation")
public class ExhibitionExhibitionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Exhibition exhibition;

    @ManyToOne(fetch = FetchType.LAZY)
    private ExhibitionGroup exhibitionGroup;

    public void setExhibition(Exhibition exhibition){
        this.exhibition = exhibition;
    }
}
