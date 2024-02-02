package it.rcs.om.cell;

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
    public double getStrength(PositionOM pointPosition) {
        double distance = getDistance(pointPosition, this.getPosition());
        return Math.ceil(Math.max(0, 100 - (distance / this.getRadius() * 100)));
    }
}
