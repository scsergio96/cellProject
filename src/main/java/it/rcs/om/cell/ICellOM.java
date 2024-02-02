package it.rcs.om.cell;

/**
 * The {@code ICellOM} define all cell functionality
 */
public interface ICellOM {

    /**
     * Calculate cell's strength based on a {@link PositionOM}
     *
     * @param position The position from where calculate the strength
     * @return the strength value
     */
    double getStrength(PositionOM position);

    /**
     * Calculate distance between two coordinates using <a href="https://www.baeldung.com/java-find-distance-between-points#calculate-the-distance-using-the-haversine-formula">Haversine Formula</a>
     *
     * @param startingPoint the starting position
     * @param endingPoint   the ending position
     * @return the distance value in km
     */
    double getDistance(PositionOM startingPoint, PositionOM endingPoint);
}
