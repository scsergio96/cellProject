package it.rcs.om;

import lombok.Data;

@Data
public abstract class AbstractCellOM{
    private String name;
    private PositionOM position;

    public abstract double calculateStrength(double latitude, double longitude);
    public double calculateDistance(double pointLatitude, double pointLongitude) {
        return 0;
    }
}
