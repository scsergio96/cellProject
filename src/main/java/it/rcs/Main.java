package it.rcs;

import it.rcs.om.cell.AbstractCellOM;
import it.rcs.om.cell.PositionOM;
import it.rcs.om.cell.PowerCellOM;
import it.rcs.om.cell.RadiusCellOM;
import it.rcs.om.event.EventOM;
import it.rcs.om.event.EventTypeOM;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final int REQUIRED_STRENGTH = 20;

    public static void main(String[] args) {
        PositionOM pointPosition = new PositionOM(9.4614873, 9.0734298);

        System.out.println("LIST OF CELLS WITH REQUIRED STRENGTH " + REQUIRED_STRENGTH);
        List<AbstractCellOM> strongerThanRequiredCell = getStrongerThanRequiredCell(pointPosition);

        System.out.println("\n\nLIST OF CELLS SORTED BY DECREASING POWER");
        decreasingStrengthOrderedCell(strongerThanRequiredCell, pointPosition);

        System.out.println("\n\nLIST OF CELLS SORTED BY EVENT COUNT");
        getCellsSortedByEventCount();
    }

    private static List<AbstractCellOM> getStrongerThanRequiredCell(PositionOM pointPosition) {
        PositionOM position1 = new PositionOM(9.4616873, 9.0756298);
        PositionOM position2 = new PositionOM(9.4616453, 9.0722598);
        List<AbstractCellOM> cellList =
                Arrays.asList(new PowerCellOM("powerCell", position1, 1.25),
                        new RadiusCellOM("radiusCell", position2, 10));
        List<AbstractCellOM> filteredCells = cellList.stream().filter(abstractCellOM -> abstractCellOM.getStrength(pointPosition) > REQUIRED_STRENGTH).toList();
        filteredCells.forEach(abstractCellOM -> System.out.printf("CELL: %s with position %s has an higher strength than %s from position %s\n", abstractCellOM, abstractCellOM.getPosition(), REQUIRED_STRENGTH, pointPosition));
        return filteredCells;
    }

    private static void decreasingStrengthOrderedCell(List<AbstractCellOM> strongerThanRequiredCell, PositionOM pointPosition) {
        List<AbstractCellOM> sortedCells = strongerThanRequiredCell.stream()
                .sorted(Comparator.comparingDouble(value -> value.getStrength(pointPosition))).collect(Collectors.toList());
        Collections.reverse(sortedCells);
        sortedCells.forEach(abstractCellOM -> System.out.printf("CELL: %s with position %s has strength %s from position %s\n", abstractCellOM, abstractCellOM.getPosition(), abstractCellOM.getStrength(pointPosition), pointPosition));
    }

    private static void getCellsSortedByEventCount() {
        PositionOM position1 = new PositionOM(45.4616873, 9.0756298);
        PositionOM position2 = new PositionOM(45.4621873, 9.0126298);
        PowerCellOM cell1 = new PowerCellOM("cell1", position1, 1);
        PowerCellOM cell2 = new PowerCellOM("cell2", position2, 1);
        EventOM event1 = new EventOM(EventTypeOM.CONNECTED, cell1, ZonedDateTime.now());
        EventOM event2 = new EventOM(EventTypeOM.CONNECTED, cell2, ZonedDateTime.now());
        EventOM event3 = new EventOM(EventTypeOM.DISCONNECTED, cell1, ZonedDateTime.now());
        List<EventOM> events = Arrays.asList(event1, event2, event3);
        Map<AbstractCellOM, Long> cellCountMap =
                events.stream().map(EventOM::getCellOM).collect(Collectors.groupingBy(abstractCellOM -> abstractCellOM, Collectors.counting()));
        cellCountMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(abstractCellOMLongEntry -> System.out.printf("CELL: %s with position %s has %s events\n", abstractCellOMLongEntry.getKey(), abstractCellOMLongEntry.getKey().getPosition(), abstractCellOMLongEntry.getValue()));
    }
}