package it.rcs.om;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PositionOM {
    private double latitude;
    private double longitude;
}
