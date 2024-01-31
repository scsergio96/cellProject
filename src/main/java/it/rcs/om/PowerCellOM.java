package it.rcs.om;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PowerCellOM extends AbstractCellOM {
    private double powerValue;

    @Override
    public double calculateStrength(double latitude, double longitude) {
        return 0;
    }
}
