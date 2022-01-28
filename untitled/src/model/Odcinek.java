package model;

public class Odcinek extends Figura {

    private Point start;
    private Double lengthX;
    private Double lengthY;

    public Odcinek(Point startW, Double initLX, Double initLY){
        name = "odcinek";
        start = startW;
        lengthX = initLX;
        lengthY = initLY;
    }

    @Override
    public void show() {
        System.out.println("Figura: "+name+" start ponit: "+start.toString()+" length x: " + lengthX + " length y: "+lengthY);
    }

    @Override
    public void resize(Double resizeFactor) {
        lengthX = lengthX*resizeFactor;
        lengthY = lengthY*resizeFactor;
    }
}
