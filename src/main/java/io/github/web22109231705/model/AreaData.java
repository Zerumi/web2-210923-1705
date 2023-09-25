package io.github.web22109231705.model;

import java.beans.JavaBean;
import java.io.Serializable;
import java.util.Objects;

@JavaBean
public class AreaData implements Serializable {
    private double x;
    private double y;
    private double r;
    private boolean result;

    public AreaData() {

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean getResult() {
        return result;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AreaData)) return false;
        AreaData areaData = (AreaData) o;
        return Double.compare(this.getX(), areaData.getX()) == 0
                && Double.compare(this.getY(), areaData.getY()) == 0
                && Double.compare(this.getR(), areaData.getR()) == 0
                && Boolean.compare(this.getResult(), areaData.getResult()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getX(), this.getY(), this.getR(), this.getResult());
    }

    @Override
    public String toString() {
        return "AreaData{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", result=" + result +
                '}';
    }
}
