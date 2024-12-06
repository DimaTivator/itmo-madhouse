package org.dimativator.itmomadhouse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
    private String login;
    private String password;
    private RoleDto role;
}
