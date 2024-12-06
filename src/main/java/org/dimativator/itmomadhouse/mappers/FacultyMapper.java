package org.dimativator.itmomadhouse.mappers;

import org.dimativator.itmomadhouse.dto.FacultyDto;
import org.dimativator.itmomadhouse.model.Faculty;

public class FacultyMapper {
    public static Faculty toEntity(FacultyDto facultyDto) {
        return Faculty.builder()
                .id(facultyDto.getId())
                .name(facultyDto.getName())
                .build();
    }

    public static FacultyDto toDto(Faculty faculty) {
        return FacultyDto.builder()
                .id(faculty.getId())
                .name(faculty.getName())
                .build();
    }
}