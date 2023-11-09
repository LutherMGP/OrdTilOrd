package com.ordtilord.mvc.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Interesse")
public class InteresseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interesseId;
    private String beskrivelse;

    @OneToMany(mappedBy = "interesse", cascade = CascadeType.ALL)
    private List<BrugerInteresseEntity> brugerInteresser;
}