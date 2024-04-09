package test.api.forJob.test.database.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@Table(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cars_id_seq")
    @SequenceGenerator(name = "cars_id_seq", sequenceName = "cars_id_seq", allocationSize = 1)
    Integer id;

    @Column(name = "driver_name", unique = true)
    String driverName;

    String brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "garage_id")
    @EqualsAndHashCode.Exclude
    GarageEntity garage;
}
