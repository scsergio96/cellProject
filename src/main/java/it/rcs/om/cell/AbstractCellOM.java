package it.rcs.om.cell;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractCellOM implements ICellOM {
    private final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;
    private String name;
    private PositionOM position;

    public AbstractCellOM(String name, PositionOM position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public double getDistance(PositionOM startingPoint, PositionOM endingPoint) {
        double dLat = Math.toRadians(endingPoint.getLatitude() - startingPoint.getLatitude());
        double dLong = Math.toRadians(endingPoint.getLongitude() - startingPoint.getLongitude());

        double startLat = Math.toRadians(startingPoint.getLatitude());
        double endLat = Math.toRadians(endingPoint.getLatitude());

        double a = haversine(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversine(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return AVERAGE_RADIUS_OF_EARTH_KM * c;
    }

    private double haversine(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }

    @Override
    public String toString() {
        return '{' +
                "name='" + name + '\'' +
                '}';
    }
}
