package model;

public class Circle extends Figura {
    private Point center;
    private Double radius;

    public Circle(Point centerP, Double initRadius){
        center = centerP;
        radius = initRadius;
        name = "kolo";
    }


    @Override
    public void show() {
        System.out.println("Figura: "+name+" center ponit: "+center.toString()+" radius: "+radius);
    }

    @Override
    public void resize(Double factor) {
        radius = radius*factor;
    }
}
