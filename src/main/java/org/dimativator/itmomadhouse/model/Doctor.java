package org.dimativator.itmomadhouse.model;

import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "cw_doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;
    
    private Date dateOfBirth;
    
    @Column(length = 100)
    private String specialisation;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Faculty faculty;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private User user;
}
