package net.anotheria.knight;

import net.anotheria.knight.Cell;
import net.anotheria.knight.TourFinder;

public class Main {

    public static void main(String[] args) {

        TourFinder tourFinder = new TourFinder(new Cell(3, 3));
        tourFinder.start();
    }
}
