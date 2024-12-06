package org.dimativator.itmomadhouse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private Long id;
    private String name;
    private java.util.Date dateOfBirth;
    private String specialisation;
    private FacultyDto faculty;
    private UserDto user;
}
