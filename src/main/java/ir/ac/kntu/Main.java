package ir.ac.kntu;

import java.util.Scanner;

/**
 * @author ArmanTakestani
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("welcome!");
        System.out.println("1-add customer:");
        System.out.println("2-add town");
        System.out.println("3-add Marsole:");
        System.out.println("4-edit customer:");
        System.out.println("5-edit Town:");
        System.out.println("6-show customers:");
        System.out.println("7-show towns:");
        System.out.println("8-show marsole:");
        System.out.println("9-filter by send methode:");
        System.out.println("10-search by send method:");
        System.out.println("11-exit:");
        int option = ScannerWrapper.getInstance().nextInt();
        switch (option) {
            case 1:
                Customer.addcustomer();
                break;
            case 2:
                Town.addtown();
                break;
            case 3:
                Marsole.addmarsole();
                break;
            case 4:
                Customer.editCustomer();
                break;
            case 5:
                Town.editTown();
                break;
            case 6:
                Customer.printCustomers();
                break;
            case 7:
                Town.printTowns();
                break;
            case 8:
                Marsole.printMarsole();
                break;
            case 9:
                filterBySendMethode();
                break;
            case 10:
                System.out.println("define type of search:");
                System.out.println("1-by air");
                System.out.println("2-Ground:");
                System.out.println("3-Marine:");
                int input = ScannerWrapper.getInstance().nextInt();
                switch (input) {
                    case 1:
                    Marsole.searchsendmethod(SendMethod.BY_AIR);
                    case 2:
                        Marsole.searchsendmethod(SendMethod.GRAUND);
                    case 3:
                        Marsole.searchsendmethod(SendMethod.MARINE);
                }
            case 11:
                return;

                }










        MapConsumer.getInstance().accept("Tehran", "Dubai");
    }
    public static void filterBySendMethode(){
        System.out.println("define filter type:");
        System.out.println("1- Graund:");
        System.out.println("2- air:");
        System.out.println("3- marine:");
        String input = ScannerWrapper.getInstance().next();
        switch (input.toLowerCase()){
            case "graund":
                for (int i = 0; i <Marsole.marsoles.size() ; i++) {
                    if(Marsole.marsoles.get(i).getSendMethod().equals(SendMethod.GRAUND)){
                        System.out.println(Marsole.marsoles.get(i));
                    }
                }
            case "air":
                for (int i = 0; i <Marsole.marsoles.size() ; i++) {
                    if(Marsole.marsoles.get(i).getSendMethod().equals(SendMethod.BY_AIR)){
                        System.out.println(Marsole.marsoles.get(i));
                    }
                }
            case "marine":
                for (int i = 0; i <Marsole.marsoles.size() ; i++) {
                    if(Marsole.marsoles.get(i).getSendMethod().equals(SendMethod.MARINE)){
                        System.out.println(Marsole.marsoles.get(i));
                    }
                }


        }
    }



}
