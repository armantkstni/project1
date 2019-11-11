package ir.ac.kntu;

import com.sun.security.ntlm.Client;

import java.util.ArrayList;
import java.util.Objects;

public class Marsole {
    private String name;
    private Customer Transmitter;
    private Customer Receiver;
    private Town marsoleTown;
    private Status status;
    private PostMethod postMethod;
    private SendMethod sendMethod;
    private int weight;
    private Date send;
    public static ArrayList<Marsole> marsoles = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Customer getTransmitter() {
        return Transmitter;
    }

    public Customer getReceiver() {
        return Receiver;
    }


    public Status getStatus() {
        return status;
    }

    public PostMethod getPostMethod() {
        return postMethod;
    }

    public SendMethod getSendMethod() {
        return sendMethod;
    }

    public int getWeight() {
        return weight;
    }

    public Date getSend() {
        return send;
    }

    public static ArrayList<Marsole> getMarsoles() {
        return marsoles;
    }

    public void setPostMethod(PostMethod postMethod) {
        this.postMethod = postMethod;
    }

    public void setSendMethod(SendMethod sendMethod) {
        this.sendMethod = sendMethod;
    }

    public Marsole(String name, Customer transmitter, Customer receiver, Town marsoleTown, int weight) {
        this.name = name;
        this.Transmitter = transmitter;
        this.Receiver = receiver;
        this.marsoleTown = marsoleTown;
        this.weight = weight;
    }

    public static void addmarsole() {
        if (Customer.getCustomers().isEmpty() && Town.getTowns().isEmpty()) {
            System.out.println("you have already define customer and town");
        } else {
            System.out.println("enter the name of marsole:");
            String marsoleName = ScannerWrapper.getInstance().next();
            System.out.println("enter the wight of marsole:");
            int weight = ScannerWrapper.getInstance().nextInt();
            System.out.println("enter the Transmitter name:");
            String transmitterName = ScannerWrapper.getInstance().next();
            System.out.println("enter the id:");
            int transmitterID = ScannerWrapper.getInstance().nextInt();
            Customer transmitter = Customer.searchCustomer(transmitterID);
            System.out.println("enter the reciver name:");
            String reciverName = ScannerWrapper.getInstance().next();
            System.out.println("enter the id:");
            int reciverid = ScannerWrapper.getInstance().nextInt();
            Customer receiver = Customer.searchCustomer(reciverid);



            System.out.println("enter the send date:(day , month,year)");
            int day1 = ScannerWrapper.getInstance().nextInt();
            int month1 = ScannerWrapper.getInstance().nextInt();
            int year1 = ScannerWrapper.getInstance().nextInt();


            Date sendDate = new Date(day1, month1, year1);


            System.out.println("enter the name of marsole town");
            String marsoleTownName = ScannerWrapper.getInstance().next();
            System.out.println("enter the cordinates for marsoleTown:(first x, second y)");
            int marsoleX = ScannerWrapper.getInstance().nextInt();
            int marsoleY = ScannerWrapper.getInstance().nextInt();
            Cordinates cordinates = new Cordinates(marsoleX,marsoleY);
            Town marsoleTown = new Town(marsoleName,cordinates);
            Marsole marsole = new Marsole(marsoleName,transmitter,receiver,marsoleTown,weight);
            marsole.setSend(sendDate);



//            System.out.println("enter the recieve date:");
//            int day2 = ScannerWrapper.getInstance().nextInt();
//            int month2 = ScannerWrapper.getInstance().nextInt();
//            int year2 = ScannerWrapper.getInstance().nextInt();


          // Date recieveDate = new Date(day2, month2, year2);
            System.out.println("define type of post :");
            System.out.println("1-normal:");
            System.out.println("2-spicial:");

            int postMethode = ScannerWrapper.getInstance().nextInt();
            switch (postMethode) {
                case 1:
                    marsole.setPostMethod(PostMethod.NORMAL);
                    break;
                case 2:
                    marsole.setPostMethod(PostMethod.SPICIAL);

            }
            System.out.println("define type of send :");
            System.out.println("1-by air");
            System.out.println("2-Ground:");
            System.out.println("3-Marine:");

            int sendMethode = ScannerWrapper.getInstance().nextInt();
            switch (sendMethode) {
                case 1:
                    marsole.setSendMethod(SendMethod.BY_AIR);
                    break;
                case 2:
                    marsole.setSendMethod(SendMethod.GRAUND);
                    break;
                case 3:
                    marsole.setSendMethod(SendMethod.MARINE);

            }
            System.out.println("define status of marsole:");
            System.out.println("1-sent");
            System.out.println("2-recived");
            System.out.println("3-notArrive");
            int status = ScannerWrapper.getInstance().nextInt();
            switch (status){
                case 1:
                    marsole.setStatus(Status.SENT);
                case 2:
                    marsole.setStatus(Status.RECIVED);
                case 3:
                    marsole.setStatus(Status.NOT_ARRIVE);


            }


        }


    }

    public Marsole(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marsole marsole = (Marsole) o;
        return weight == marsole.weight &&
                Objects.equals(name, marsole.name) &&
                Objects.equals(Transmitter, marsole.Transmitter) &&
                Objects.equals(Receiver, marsole.Receiver) &&
                status == marsole.status &&
                postMethod == marsole.postMethod &&
                sendMethod == marsole.sendMethod &&
                Objects.equals(send, marsole.send);
    }

    public void setSend(Date send) {
        this.send = send;
    }


    @Override
    public int hashCode() {

        return Objects.hash(name, Transmitter, Receiver,marsoleTown, status, postMethod, sendMethod, weight);
    }
    public static void searchsendmethod(SendMethod sendMethod){
        for (int i = 0; i <Marsole.marsoles.size(); i++) {
            if(marsoles.get(i).getSendMethod().equals(sendMethod)){
                System.out.println(marsoles.get(i));
            }
            else {
                System.out.println("not exist");
            }

        }

    }
    public static void searchPostmethode(PostMethod postMethod){
        for (int i = 0; i <marsoles.size() ; i++) {
            if(marsoles.get(i).getPostMethod().equals(postMethod)){
                System.out.println(marsoles.get(i));
            }
            else {
                System.out.println("not exist");
            }
        }
    }
    public static void printMarsole(){
        if(marsoles.isEmpty()){
            System.out.println("marsoles is empty!");
        }
        else {
            for (int i = 0; i < marsoles.size(); i++) {
                System.out.println(marsoles.get(i));
            }
        }
    }


}
