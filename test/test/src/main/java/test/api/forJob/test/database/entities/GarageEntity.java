package test.api.forJob.test.database.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@Table(name = "garages")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GarageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "garages_id_seq")
    @SequenceGenerator(name = "garages_id_seq", sequenceName = "garages_id_seq", allocationSize = 1)
    Integer id;

    String name;

    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "garage", orphanRemoval = true)
    List<CarEntity> cars = new ArrayList<>();
}
