package it.rcs;

import it.rcs.om.AbstractCellOM;
import it.rcs.om.PositionOM;
import it.rcs.om.PowerCellOM;
import it.rcs.om.RadiusCellOM;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final int REQUIRED_STRENGTH = 20;

    public static void main(String[] args) {
        PositionOM position1 = new PositionOM(45.4616873, 9.0756298);
        PositionOM position2 = new PositionOM(45.4616873, 9.0756298);
        List<AbstractCellOM> cellList =
                Arrays.asList(new PowerCellOM("powerCell", position1, 0.01),
                        new RadiusCellOM("radiusCell", position1, 10));

        List<AbstractCellOM> strongerThanRequiredCell = cellList.stream().filter(abstractCellOM -> abstractCellOM.getStrength(position1) > REQUIRED_STRENGTH).toList();

        List<AbstractCellOM> sortedCells = strongerThanRequiredCell.stream()
                .sorted(Comparator.comparingDouble(value -> value.getStrength(position1)))
                .collect(Collectors.collectingAndThen(Collectors.toList(), abstractCellOMS -> {
                    Collections.reverse(abstractCellOMS);
                    return abstractCellOMS;
                }));

        /*
        • Dato un elenco di celle e un Punto (definito con Latitudine e Longitudine):
            o filtrare quelle che hanno una forza maggiore di un valore dato nel Punto
            o restituire le celle individuate ordinate per forza decrescente
        • Data una serie di Eventi di Cella:
            o estrarre tutte le celle in ordine di frequenza (ovvero dalla più comune alla più rara).
         */


    }
}