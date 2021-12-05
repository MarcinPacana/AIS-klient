package pl.marcin.aisklient.model;

public class Main {
    public static void main(String[] args) {

    Datum datum = new Datum();

    Main main = new Main();

        Datum element = main.getElement(datum);

        Geometry geometry = new Geometry();
        Geometry element1 = main.getElement(geometry);


    }

    private  <T> T getElement(T element){
        String s = element.toString();
        System.out.println(s);
        return element;
    }

}

