package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Objects;

public class Town {
    private String name;
    private Cordinates cordinates;
    private static ArrayList<Town> towns;

    public static ArrayList<Town> getTowns() {
        return towns;
    }

    public Town(String name, Cordinates cordinates) {
        this.name = name;
        this.cordinates = cordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cordinates getCordinates() {
        return cordinates;
    }

    public void setCordinates(Cordinates cordinates) {
        this.cordinates = cordinates;
    }

    public static void addtown(){
        System.out.println("enter the first town:");
        String name1 = ScannerWrapper.getInstance().next();
        System.out.println("enter the cordinates for first town (first x , second y):");
        int x1 = ScannerWrapper.getInstance().nextInt();
        int y1 = ScannerWrapper.getInstance().nextInt();


        Cordinates firstcordinates = new Cordinates(x1, y1);

        System.out.println("enter the second town:");
        String name2 = ScannerWrapper.getInstance().next();
        System.out.println("enter the cordinates for second town (first x , second y):");
        int x2 = ScannerWrapper.getInstance().nextInt();
        int y2 = ScannerWrapper.getInstance().nextInt();


        Cordinates secondcordinates = new Cordinates(x2, y2);

        Town town1 = new Town(name1, firstcordinates);
        Town town2 = new Town(name2, secondcordinates);
        towns.add(town1);
        towns.add(town2);
        if (towns.contains(town1)&&towns.contains(town2)){
            System.out.println("towns already exist!");
        }



    }

    public static Town searchtown(String name){
        for (int i = 0; i <towns.size() ; i++) {
            if(towns.get(i).equals(name)){
                return towns.get(i);
            }
        }
        return null;
    }
    public static void editTown(){
        System.out.println("enter the name of old town:");
        String oldTown = ScannerWrapper.getInstance().next();
        System.out.println("enter the name of new town:");
        String newTown = ScannerWrapper.getInstance().next();
        searchtown(oldTown).setName(newTown);
    }
    public static void printTowns(){
        for (int i = 0; i <towns.size() ; i++) {
            System.out.println(towns.get(i));
        }
    }

    @Override
    public String toString() {
        return "Town{" +
                "name='" + name + '\'' +
                ", cordinates=" + cordinates +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Town town = (Town) o;
        return Objects.equals(name, town.name) &&
                Objects.equals(cordinates, town.cordinates);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, cordinates);
    }

}
