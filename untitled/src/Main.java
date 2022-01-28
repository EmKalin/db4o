//EMilia Kalińska B2.n

import controller.DB4O_Handler;
import model.Circle;
import model.Draw;
import model.Odcinek;
import model.Point;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DB4O_Handler db_handler = new DB4O_Handler();

        System.out.println("-------------------- Zadanie nr 1 --------------------");
        db_handler.deleteOldDB();
        db_handler.connectToDB();

        Odcinek odcinek1 = new Odcinek(new Point(2.0,2.0), 4.0, 3.0);
        Odcinek odcinek2 = new Odcinek(new Point(1.0,2.0), 3.0, 4.0);

        List<Odcinek> initListOdcinki = new ArrayList<>();
        initListOdcinki.add(odcinek1);
        initListOdcinki.add(odcinek2);

        Draw venus = new Draw("venus", initListOdcinki, null);
        db_handler.addDraw(venus);
        db_handler.closeDB();



        System.out.println("-------------------- Zadanie nr 2 --------------------");
        db_handler.connectToDB();
        db_handler.printAllDrawInDB();


        Odcinek odcinekRys2 = new Odcinek(new Point(1.0,1.0), 4.0, 3.0);
        List<Odcinek> initListRys2 = new ArrayList<>();
        initListRys2.add(odcinekRys2);

        Circle circle1 = new Circle(new Point(1.0,7.0), 4.0);
        List<Circle> circleRys2 = new ArrayList<>();
        circleRys2.add(circle1);

        Draw syrius = new Draw("syrius", initListRys2, circleRys2);
        db_handler.addDraw(syrius);

        db_handler.closeDB();


        System.out.println("-------------------- Zadanie nr 3 --------------------");
        db_handler.connectToDB();
        db_handler.printAllDrawInDB();


        db_handler.scaleDraw("venus", 10.0);
        db_handler.closeDB();


        System.out.println("-------------------- Zadanie nr 4 --------------------");

        db_handler.connectToDB();
        db_handler.printAllDrawInDB();

        db_handler.removeFirstcircle("syrius");

        db_handler.closeDB();


        System.out.println("-------------------- Zadanie nr 5 --------------------");

        db_handler.connectToDB();
        db_handler.printAllDrawInDB();

        Circle newCirclezad5 = new Circle(new Point(3.0,2.0), 5.0);
        db_handler.addCircletoDraw("venus", newCirclezad5);

        db_handler.closeDB();


        System.out.println("-------------------- Zadanie nr 6 --------------------");

        db_handler.connectToDB();

        db_handler.printAllDrawInDB();

        db_handler.closeDB();
    }
}
