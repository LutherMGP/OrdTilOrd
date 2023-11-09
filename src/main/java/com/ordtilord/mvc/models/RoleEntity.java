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
@Entity(name = "Role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    private String navn;

    @ManyToMany(mappedBy = "roles")
    private List<BrugerEntity> brugere;
}
