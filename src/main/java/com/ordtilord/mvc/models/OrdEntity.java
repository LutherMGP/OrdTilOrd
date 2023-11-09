package com.ordtilord.mvc.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Ord")
public class OrdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordliste_id", nullable = false)
    private OrdlisteEntity ordliste;

    private String ordTekst;
}



