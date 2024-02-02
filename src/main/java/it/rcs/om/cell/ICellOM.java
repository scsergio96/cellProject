package it.rcs.om.cell;

public interface ICellOM {

    double getStrength(PositionOM position);
    double getDistance(PositionOM startingPoint, PositionOM endingPoint);
}
