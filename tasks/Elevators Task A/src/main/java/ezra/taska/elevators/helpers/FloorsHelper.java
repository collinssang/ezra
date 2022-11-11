package ezra.taska.elevators.helpers;


import java.util.Objects;

/**
 * Collins K. Sang
 * 11/10/22 9:17 AM
 * Elevators
 * FloorsHelper
 * IntelliJ IDEA
 **/
public class FloorsHelper {
    private int floorNo;
    private boolean up;

    public FloorsHelper(int floorNo, boolean up) {
        this.floorNo = floorNo;
        this.up = up;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FloorsHelper floorsHelper = (FloorsHelper) o;
        return floorNo == floorsHelper.floorNo && up == floorsHelper.up;
    }

    @Override
    public int hashCode() {
        return Objects.hash(floorNo, up);
    }
}
