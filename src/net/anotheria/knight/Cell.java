package net.anotheria.knight;

public class Cell implements Comparable {

    public Cell() {
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /* horizontal coordinate*/
    private int x;

    /* vertical coordinate*/
    private int y;

    /* Available cells amount for current cell
     * Initial size is 8 - all possible moves for knight
     */
    private int availableCells = 8;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
