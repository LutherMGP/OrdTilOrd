package com.ordtilord.mvc.models;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "BrugerInteresse")
public class BrugerInteresseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brugerInteresseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bruger_id", nullable = false)
    private BrugerEntity bruger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interesse_id", nullable = false)
    private InteresseEntity interesse;
}
