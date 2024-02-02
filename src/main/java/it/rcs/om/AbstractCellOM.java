package it.rcs.om;

import lombok.Data;

@Data
public abstract class AbstractCellOM implements ICellOM {
    private final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;
    private String name;
    private PositionOM position;

    public AbstractCellOM(String name, PositionOM position) {
        this.name = name;
        this.position = position;
    }

    public double getDistance(PositionOM pointPosition) {

        double dLat = Math.toRadians(pointPosition.getLatitude() - position.getLatitude());
        double dLong = Math.toRadians(pointPosition.getLongitude() - position.getLongitude());

        position.setLatitude(Math.toRadians(position.getLatitude()));
        pointPosition.setLatitude(Math.toRadians(pointPosition.getLatitude()));

        double a = haversine(dLat) + Math.cos(position.getLatitude()) * Math.cos(pointPosition.getLatitude()) * haversine(dLong);
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
