package org.dimativator.itmomadhouse.mappers;

import org.dimativator.itmomadhouse.dto.CreatureDto;
import org.dimativator.itmomadhouse.model.Creature;

public class CreatureMapper {
    public static Creature toEntity(CreatureDto creatureDto) {
        return Creature.builder()
                .id(creatureDto.getId())
                .name(creatureDto.getName())
                .build();
    }

    public static CreatureDto toDto(Creature creature) {
        return CreatureDto.builder()
                .id(creature.getId())
                .name(creature.getName())
                .build();
    }
} 