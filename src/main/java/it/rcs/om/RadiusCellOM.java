package it.rcs.om;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RadiusCellOM extends AbstractCellOM {
    private double radius;

    @Override
    public double calculateStrength(double latitude, double longitude) {
        return 0;
    }
}
