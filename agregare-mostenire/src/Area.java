public class Area {
    protected CandyBag bagOfCandy;
    protected int number;
    protected String street;

    public Area() {
    }

    public Area(CandyBag bagOfCandy, int number, String street) {
        this.bagOfCandy = bagOfCandy;
        this.number = number;
        this.street = street;
    }

    public void getBirthdayCard() {
        System.out.println(street + " " + number);
        System.out.println("la multi ani");
    }

    public void printToString() {
        for (CandyBox box : bagOfCandy.bag) {
            System.out.println(box.toString());
        }
    }

    public void printDim() {
        //Aceasta este prima varianta, cu instanceof
        /*
        for(CandyBox box : bagOfCandy.bag) {
            if(box instanceof Lindt) {
                ((Lindt) box).PrintLindtDim();
            } else if (box instanceof Baravelli) {
                ((Baravelli) box).PrintBaravelliDim();
            } else if (box instanceof ChocAmor) {
                ((ChocAmor) box).PrintChocAmorDim();
            }
        }
        */
        for(CandyBox box : bagOfCandy.bag) {
            box.Print();
        }
    }
}
