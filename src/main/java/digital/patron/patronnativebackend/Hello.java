package digital.patron.patronnativebackend;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Hello {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}