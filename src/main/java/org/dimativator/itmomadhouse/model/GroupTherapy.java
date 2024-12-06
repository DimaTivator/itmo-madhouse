package org.dimativator.itmomadhouse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "cw_group_therapy")
public class GroupTherapy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private PatientGroup patientGroup;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Artifact artifact;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Creature creature;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Spell spell;

    @Column(name = "therapy_date")
    private java.time.LocalDate therapyDate;
}
