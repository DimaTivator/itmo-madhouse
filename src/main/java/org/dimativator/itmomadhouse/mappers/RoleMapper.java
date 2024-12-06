package org.dimativator.itmomadhouse.mappers;

import org.dimativator.itmomadhouse.dto.RoleDto;
import org.dimativator.itmomadhouse.model.Role;

public class RoleMapper {
    public static RoleDto toDto(Role role) {
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

    public static Role toEntity(RoleDto roleDto) {
        return Role.builder()
                .id(roleDto.getId())
                .name(roleDto.getName())
                .build();
    }
}
