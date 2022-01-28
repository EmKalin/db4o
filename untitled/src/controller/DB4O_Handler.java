package controller;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import model.Circle;
import model.Draw;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DB4O_Handler {
    private static final String DB4OFILENAME = "my_db";
    private ObjectContainer db;

    public DB4O_Handler() {}

    public void connectToDB() {
        System.out.println("**** Connecting to database ****");
        db = Db4oEmbedded.openFile(Db4oEmbedded
                .newConfiguration(), DB4OFILENAME);
        db.ext().configure().updateDepth(10);
    }

    public void deleteOldDB() {
        File myObj = new File(DB4OFILENAME);
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public void scaleDraw(String name, Double factor){
        ObjectSet result = QBE(new Draw(name, new ArrayList<>(), new ArrayList<>()));

        Draw found = (Draw) result.next();
        found.scaleDraw(factor);
        db.store(found);

    }


    public void removeFirstcircle(String name){
        ObjectSet result = QBE(new Draw(name, new ArrayList<>(), new ArrayList<>()));
        Draw found = (Draw) result.next();
        found.remoweFirstCircle();
        db.store(found);

    }

    public void addCircletoDraw(String name, Circle newCircle){
        ObjectSet result = QBE(new Draw(name, new ArrayList<>(), new ArrayList<>()));
        Draw found = (Draw) result.next();
        found.addNewCIrcle(newCircle);
        db.store(found);
    }

    public static void showDraws(List<Draw> list) {
        System.out.println("Showing objects");
        for (Draw obj : list) {
             obj.printAllFigures();
        }
    }

    public void addDraw(Draw draw){
        db.store(draw);
    }

    public void printAllDrawInDB(){
        ObjectSet objectSet = QBE(new Draw(null, new ArrayList<>(), new ArrayList<>()));
        showDraws(objectSet);
    }


    public ObjectSet QBE(Object obj) {
        return db.queryByExample(obj);
    }

    public void closeDB() {
        System.out.println("#### Closing database ####\r\n");
        this.db.close();
    }
}
