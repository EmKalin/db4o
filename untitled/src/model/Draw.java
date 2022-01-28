package model;

import java.util.ArrayList;
import java.util.List;

public class Draw {
    private String name;
    private List<Odcinek> odcinki;
    private List<Circle> allCircle;

    public Draw(String nameDraw, List<Odcinek> initOd, List<Circle> initCir){
        name = nameDraw;
        odcinki = initOd;
        allCircle = initCir;
    }

    public void printAllFigures(){
        System.out.println("Draw name: "+ name);
        System.out.println("Odcinki:");
        if(odcinki != null){
            for(Odcinek o: odcinki){
                o.show();
            }
        }
        System.out.println("Circles:");

        if(allCircle != null){
            for(Circle c: allCircle){
                c.show();
            }
        }

    }

    public void scaleDraw(Double factor){
        if(odcinki != null && odcinki.size()>0){
            for(Odcinek o: odcinki){
                o.resize(factor);
            }
        }
        System.out.println("Circles:");

        if(allCircle != null && allCircle.size()>0){
            for(Circle c: allCircle){
                c.resize(factor);
            }
        }
    }

    public void remoweFirstCircle(){
        if(allCircle != null && allCircle.size()>0){
            allCircle.remove(0);
        }
    }

    public void addNewCIrcle(Circle newCircle){
        if(allCircle == null){
            allCircle = new ArrayList<>();
        }
        allCircle.add(newCircle);
    }
}
