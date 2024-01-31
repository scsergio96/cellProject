package it.rcs.om;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RadiusCellOM extends AbstractCellOM {

    private double radius;

    public RadiusCellOM(String name, PositionOM position, double radius) {
        super(name, position);
        this.radius = radius;
    }

    @Override
    public double calculateStrength(PositionOM pointPosition) {
        double distance = calculateDistance(pointPosition);
        return Math.max(0, 100 - (distance / radius * 100));
    }
}
