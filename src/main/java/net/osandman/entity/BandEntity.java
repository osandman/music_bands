package net.osandman.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BandEntity {
    private int bandId;
    private String name;
    private int year;
    private String comment;
}
