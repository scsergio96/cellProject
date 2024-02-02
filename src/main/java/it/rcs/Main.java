package it.rcs;

import it.rcs.om.*;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final int REQUIRED_STRENGTH = 20;

    public static void main(String[] args) {

        System.out.println("LIST OF CELLS WITH REQUIRED STRENGTH " + REQUIRED_STRENGTH);
        getStrongerThanRequiredCell();

        System.out.println("\n\nLIST OF CELLS SORTED BY DECREASING POWER");
        decreasingPowerOrderedCell();

        System.out.println("\n\nLIST OF CELLS SORTED BY EVENT COUNT");
        getCellsSortedByEventCount();
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
                .forEach(abstractCellOMLongEntry -> System.out.println("CELL: " + abstractCellOMLongEntry.getKey() + " HAS " + abstractCellOMLongEntry.getValue() + " EVENTS"));
    }

    private static void decreasingPowerOrderedCell() {
        PositionOM position1 = new PositionOM(45.4616873, 9.0756298);
        PositionOM position2 = new PositionOM(45.464673, 9.07248);
        List<AbstractCellOM> cellList =
                Arrays.asList(new PowerCellOM("powerCell", position1, 1.5),
                        new RadiusCellOM("radiusCell", position1, 10));
        List<AbstractCellOM> sortedCells = cellList.stream()
                .sorted(Comparator.comparingDouble(value -> value.getStrength(position2))).collect(Collectors.toList());
        Collections.reverse(sortedCells);
        sortedCells.forEach(abstractCellOM -> System.out.printf("CELL: %s has strength %s from position %s\n", abstractCellOM, abstractCellOM.getStrength(position2), position2));
    }

    private static void getStrongerThanRequiredCell() {
        PositionOM position1 = new PositionOM(9.4616873, 9.0756298);
        PositionOM position2 = new PositionOM(9.4616453, 9.0722598);
        PositionOM position3 = new PositionOM(9.4616873, 9.0765298);
        List<AbstractCellOM> cellList =
                Arrays.asList(new PowerCellOM("powerCell", position1, 156),
                        new RadiusCellOM("radiusCell", position2, 10));
        cellList.stream().filter(abstractCellOM -> abstractCellOM.getStrength(position3) > REQUIRED_STRENGTH)
                .forEach(abstractCellOM -> System.out.printf("CELL: %s with position %s has an higher strength than %s", abstractCellOM, abstractCellOM.getPosition(), REQUIRED_STRENGTH));
    }

}