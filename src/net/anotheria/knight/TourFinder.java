package net.anotheria.knight;

import java.util.*;

public class TourFinder {

    /**
     * Start of the knight tour.
     */
    private Cell startPosition;

    /**
     * Length of the board side(in cells).
     */
    private int boardSide = 8;

    /**
     * Cells amount on the board.
     */
    private int boardSize = boardSide * boardSide;

    /**
     * Object for printing result.
     */
    private TourPrinter tourPrinter = new TourPrinter();


    /**
     * @param startPosition initialize startPosition.
     */
    public TourFinder(Cell startPosition) {
        this.startPosition = startPosition;
    }

    /**
     * Program entry.
     */
    public void start() {
        getNextCell(new ArrayList<Cell>(), startPosition);
    }

    /**
     * Looks up for a new Cell to go.
     *
     * @param currentVisitedCells list of visited cells from previous iteration.
     * @param cell                chosen cell on previous iteration.
     */
    private void getNextCell(List<Cell> currentVisitedCells, Cell cell) {

        currentVisitedCells.add(cell);

        List<Cell> availableCells = getAllAvailableCells(cell);

        //End program statement. Fires when result found.
        //Evolve printer for printing result, calculate working time and close the program.
        if (currentVisitedCells.size() == boardSize && availableCells.contains(startPosition)) {
            tourPrinter.printTour(currentVisitedCells);
            System.exit(0);
        }

        //Filter possible cells from visited cells.
        availableCells.removeAll(currentVisitedCells);

        //Returns when no cells where to go.
        if (availableCells.size() == 0) {
            return;
        }

        sortByAvailableCells(availableCells);

        //Creation of new recursive iteration for each cell in list, if this element not visited before.
        for (Cell availableCell : availableCells) {

            List<Cell> tempCurrentVisitList = new ArrayList<>(currentVisitedCells);

            if (!tempCurrentVisitList.contains(availableCell)) {
                getNextCell(tempCurrentVisitList, availableCell);
            }
        }
    }

    //Finds all available cells on board where knight could go. No check for visited cells.
    private List<Cell> getAllAvailableCells(Cell cell) {

        //All possible delta's for knight moving.
        int[] xDelta = {1, -1, -2, 2, -1, 1, 2, -2};
        int[] yDelta = {2, -2, 1, -1, 2, -2, 1, -1};

        List<Cell> availableCells = new ArrayList<>();

        final int possibleMovesAmount = 8;

        for (int i = 0; i < possibleMovesAmount; i++) {
            Cell tempCell = new Cell(cell.getX() + xDelta[i], cell.getY() + yDelta[i]);
            if (isCellOnBoard(tempCell)) {
                availableCells.add(tempCell);
            }
        }
        return availableCells;
    }

    //Checking for cell is in board bounds.
    private boolean isCellOnBoard(Cell cell) {
        return !(cell.getX() < 0 || cell.getX() > boardSide - 1 || cell.getY() < 0 || cell.getY() > boardSide - 1);
    }

    //Calculates all.Sorts list of cells by it available cells.
    private void sortByAvailableCells(List<Cell> cells) {

        for (Cell cell : cells) {
            cell.setAvailableCells(getAllAvailableCells(cell).size());
        }

        Collections.sort(cells, new Comparator<Cell>() {
            public int compare(Cell с1, Cell с2) {
                return с1.compareTo(с2);
            }
        });
    }


}
