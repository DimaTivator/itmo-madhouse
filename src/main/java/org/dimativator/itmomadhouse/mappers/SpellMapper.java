package org.dimativator.itmomadhouse.mappers;

import org.dimativator.itmomadhouse.dto.SpellDto;
import org.dimativator.itmomadhouse.model.Spell;

public class SpellMapper {
    public static Spell toEntity(SpellDto spellDto) {
        return Spell.builder()
                .id(spellDto.getId())
                .name(spellDto.getName())
                .effect(spellDto.getEffect())
                .build();
    }

    public static SpellDto toDto(Spell spell) {
        return SpellDto.builder()
                .id(spell.getId())
                .name(spell.getName())
                .effect(spell.getEffect())
                .build();
    }
} 