package it.rcs;

import it.rcs.om.AbstractCellOM;
import it.rcs.om.PositionOM;
import it.rcs.om.PowerCellOM;
import it.rcs.om.RadiusCellOM;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PositionOM position1 = new PositionOM(45.4616873, 9.0756298);
        PositionOM position2 = new PositionOM(45.4616873, 9.0756298);
        List<AbstractCellOM> cellList =
                Arrays.asList(new PowerCellOM("powerCell", position1, 0.00),
                        new RadiusCellOM("radiusCell", position1, 10));
        cellList.forEach(abstractCellOM -> System.out.println(abstractCellOM.calculateStrength(position2)));

    }
}