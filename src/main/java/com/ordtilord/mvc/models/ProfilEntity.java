package com.ordtilord.mvc.models;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Profil")
public class ProfilEntity {
    @Id
    @Column(name = "profil_id")
    private Long profilId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private BrugerEntity bruger;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ordliste_id")
    private OrdlisteEntity ordliste;

    private int alder;
    private String klassetrin;
    private String niveau;
}
