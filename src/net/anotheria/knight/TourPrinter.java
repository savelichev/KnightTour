package net.anotheria.knight;

import java.util.List;

/**
 * Prints knight tour.
 */
public class TourPrinter {


    /**
     * Prints knight tour into console.
     *
     * @param tour list of cells(knight steps)
     */
    public void printTour(List<Cell> tour) {

        int shiftToAlphabet = 97;

        for (Cell cell : tour) {
            System.out.print(((char) (cell.getX() + shiftToAlphabet)) + "" + (cell.getY() + 1) + ", ");
        }
        System.out.println();
    }

}
