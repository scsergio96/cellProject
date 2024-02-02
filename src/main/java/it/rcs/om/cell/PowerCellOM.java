package it.rcs.om.cell;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PowerCellOM extends AbstractCellOM {
    private final double powerValue;

    public PowerCellOM(String name, PositionOM position, double powerValue) {
        super(name, position);
        this.powerValue = powerValue;
    }

    @Override
    public double getStrength(PositionOM pointPosition) {
        double distance = getDistance(pointPosition, this.getPosition());
        return Math.ceil(Math.max(0, 1 / Math.pow(distance, powerValue)));
    }
}
