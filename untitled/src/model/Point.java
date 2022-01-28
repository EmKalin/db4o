package model;

public class Point {
    private Double x;
    private Double y;

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Point(double initX, double initY){
        x = initX;
        y = initY;
    }

    public void moved(Double dx, Double dy){
        this.x += dx;
        this.y += dy;
    }

    public String toString(){
        return "Point -> x:" + String.valueOf(x) + ", y:" + String.valueOf(y);
    }
}
