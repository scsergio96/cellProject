package it.rcs.om.cell;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PositionOM {
    private double latitude;
    private double longitude;

    @Override
    public String toString() {
        return '{' +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
