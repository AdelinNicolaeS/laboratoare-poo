import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        CandyBox candyBox = new CandyBox("amaruie", "elvetia");
        System.out.println(candyBox.toString());

        Lindt l = new Lindt("dulce", "romania", 5, 6 ,7);
        System.out.println(l.toString());

        Baravelli b = new Baravelli("amaruie", "germania", 2, 3);
        System.out.println(b.toString());

        ChocAmor c = new ChocAmor("semidulce", "sua", 4);
        System.out.println(c.toString());

        Lindt l1 = new Lindt("dulce", "bulgaria", 5, 6 ,7);
        Lindt l2 = new Lindt("dulce", "bulgaria", 6, 7, 8);
        System.out.println(l1.equals(l2)); // afiseaza true deoarece compara numai flavor si origin

        CandyBag candyBag = new CandyBag();
        candyBag.getBag().add(l);
        candyBag.getBag().add(b);
        candyBag.getBag().add(c);
        candyBag.getBag().add(l1);

        Area area = new Area(candyBag, 321, "Bulevardul Tenerife");
        area.getBirthdayCard();
        area.printToString();
        area.printDim();
    }
}
