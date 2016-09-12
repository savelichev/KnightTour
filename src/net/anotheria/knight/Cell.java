package net.anotheria.knight;

/**
 * Entity of knight coordinates.
 */
public class Cell implements Comparable {

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * horizontal coordinate
     */
    private int x;

    /**
     * vertical coordinate
     */
    private int y;

    /**
     * Available cells amount for current cell
     * Initial size is 8 - all possible moves for knight
     */
    private int availableCells = 8;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAvailableCells() {
        return availableCells;
    }

    public void setAvailableCells(int availableCells) {
        this.availableCells = availableCells;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return x == cell.x && y == cell.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Compares cells by they coordinates.
     *
     * @param o target to compare with.
     * @return result of compare.
     */
    @Override
    public int compareTo(Object o) {
        Cell anotherCell = (Cell) o;
        if (this.getAvailableCells() < anotherCell.getAvailableCells())
            return -1;
        else if (this.getAvailableCells() == anotherCell.getAvailableCells()) {
            return 0;
        } else return 1;
    }
}
