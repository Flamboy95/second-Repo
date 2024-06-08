import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class HotelReservationSystem {
    public static void main(String[] Ark) {
        // Installation
        App Hotel = new App();
        Hotel.Install();
    }
}

class Server {
    public static Scanner sc = new Scanner(System.in);

    public static Integer FindRoom(int Decider) {
        switch (Decider) {
            case 101 -> Decider = 1;
            case 102 -> Decider = 2;
            case 103 -> Decider = 3;
            case 104 -> Decider = 4;
            case 105 -> Decider = 5;
            case 106 -> Decider = 6;
            case 107 -> Decider = 7;
            case 108 -> Decider = 8;
            case 109 -> Decider = 9;
            case 110 -> Decider = 10;
            default -> Decider = 0;
        }
        return null;
    }

    public static void Initialize() {
        Database.RoomNo.add(101);
        Database.RoomNo.add(102);
        Database.RoomNo.add(103);
        Database.RoomNo.add(104);
        Database.RoomNo.add(105);
        Database.RoomNo.add(106);
        Database.RoomNo.add(107);
        Database.RoomNo.add(108);
        Database.RoomNo.add(109);
        Database.RoomNo.add(110);
        Database.RoomType.add("Single");
        Database.RoomType.add("Single");
        Database.RoomType.add("Double");
        Database.RoomType.add("Double");
        Database.RoomType.add("Suite");
        Database.RoomType.add("Suite");
        Database.RoomType.add("Suite");
        Database.RoomType.add("Deluxe");
        Database.RoomType.add("Deluxe");
        Database.RoomType.add("Deluxe");
        Database.RoomPrice.add(100D);
        Database.RoomPrice.add(100D);
        Database.RoomPrice.add(200D);
        Database.RoomPrice.add(200D);
        Database.RoomPrice.add(300D);
        Database.RoomPrice.add(300D);
        Database.RoomPrice.add(300D);
        Database.RoomPrice.add(400D);
        Database.RoomPrice.add(400D);
        Database.RoomPrice.add(400D);
        Database.RoomAvailability.add(true);
        Database.RoomAvailability.add(true);
        Database.RoomAvailability.add(true);
        Database.RoomAvailability.add(true);
        Database.RoomAvailability.add(true);
        Database.RoomAvailability.add(true);
        Database.RoomAvailability.add(true);
        Database.RoomAvailability.add(true);
        Database.RoomAvailability.add(true);
        Database.RoomAvailability.add(true);
    }

    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Database {
    public static Vector<Integer> RoomNo = new Vector<>();
    public static Vector<String> RoomType = new Vector<>();
    public static Vector<Boolean> RoomAvailability = new Vector<>();
    public static Vector<Double> RoomPrice = new Vector<>();
    public static int Phone, Age, Addhar, Decider;
    public static String Name, Email, Gender;
    public static int UserRoomNo;
    public static boolean Login;
}

class FrontEnd {

    public static void MainMenu() {
        System.out.println(" : [1] User Booking Details Form :");
        System.out.println(" : [2]---------Visit Rooms-------: ");
        System.out.println(" : [3]---------Book Rooms--------: ");
        System.out.println(" : [4]---------Cancel Rooms------: ");
        System.out.println(" : [5]----------Exit-------------: ");
        System.out.println(" : Enter your Choice :");
        int choice = Server.sc.nextInt();
        switch (choice) {
            case 1 -> UserForm();
            case 2 -> BackEnd.Traverse();
            case 3 -> BackEnd.BookRoom();
            case 4 -> BackEnd.CancelBooking();
            case 5 -> App.Uninstall();
            default -> {
                System.out.println("Invalid Input");
                MainMenu();
            }
        }
    }

    public static void HotelIntro() {
        System.out.println("Welcome to Hotel Reservation System Form");
    }

    public static void UserForm() {
        if (Database.Login) {
            System.out.println(" : You are already Filled the Required form : ");
            MainMenu();
        } else {
            HotelIntro();
            UserName();
            UserEmail();
            UserPhone();
            UserAge();
            UserGender();
            UserAddhar();
            Database.Login = true;
        }
    }

    public static void UserName() {
        try {
            System.out.println("Enter your name : ");
            Database.Name = Server.sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println(": Input Mismatch Error : \n : plz Enter String Value :");
            UserName();
        }
    }

    public static void UserEmail() {
        try {
            System.out.println("Enter your email : ");
            Database.Email = Server.sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println(": Input Mismatch Error : \n : plz Enter String Value :");
            UserEmail();
        }
    }

    public static void UserPhone() {
        try {
            System.out.println("Enter your phone number : ");
            Database.Phone = Server.sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(": Input Mismatch Error : \n : plz Enter Integer Value :");
            UserPhone();
        }
    }

    public static void UserAge() {
        try {
            System.out.println("Enter your Age(Probable more than 18)");
            Database.Age = Server.sc.nextInt();
            if (Database.Age < 18) {
                ErrorLoop: while (Database.Age < 18) {
                    System.out.println(" : User Age Cannot be Smaller Than 18 :");
                    UserAge();
                    if (Database.Age > 18) {
                        break ErrorLoop;
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(": Input Mismatch Error : \n : plz Enter Integer Value :");
            UserAge();
        }
    }

    public static void UserGender() {
        int select = 0;
        try {
            System.out.println(" : Select Gender : \n");
            System.out.println("  : [1] Male \n : [2] Female \n : [3] LGBTQ");
            select = Server.sc.nextInt();
            switch (select) {
                case 1 -> Database.Gender = "Male";
                case 2 -> Database.Gender = "Female";
                case 3 -> Database.Gender = "LGBTQ";
                default -> {
                    System.out.println("Wrong Choice Be careful!!");
                    UserAge();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(": Input Mismatch Error : \n : plz Enter Integer Value :");
            UserGender();
        }
    }

    public static void UserAddhar() {
        try {
            System.out.println("Enter Addhar Card Number:");
            Database.Addhar = Server.sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(": Input Mismatch Error : \n : plz Enter Integer Value :");
            UserAddhar();
        }
    }
}

class BackEnd {
    public static void Traverse() {
        System.out.println(" : Room Number :" + Database.RoomNo);
        System.out.println(" : Room Type   :" + Database.RoomType);
        System.out.println(" : Room Price  : " + Database.RoomPrice);
        Server.sc.next();
        FrontEnd.MainMenu();
    }

    public static void BookRoom() {
        try {
            System.out.println("Enter Room Number " + Database.RoomNo + " : ");
            Database.UserRoomNo = Server.sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(" : Plx InputMismatchException : \n : Enter Integer Value :");
            Database.UserRoomNo = Server.sc.nextInt();
        }
        Server.FindRoom(Database.UserRoomNo);
        ProcessRoomBooking();
    }

    public static void ProcessRoomBooking() {
        if (Database.Decider == 0) {
            System.out.println(" : Wrong Room Number Entered :");
            FrontEnd.MainMenu();
        } else {
            Database.RoomAvailability.set(Database.Decider, false);
            System.out.println("Room Booking Successfully");
            System.out.println(" : Report : ");
            System.out.println(" :-Name--------: " + Database.Name);
            System.out.println(" :-Email-------: " + Database.Email);
            System.out.println(" :-Phone-------: " + Database.Phone);
            System.out.println(" :-Age---------: " + Database.Age);
            System.out.println(" :-Gender------: " + Database.Gender);
            System.out.println(" :-Addhar------: " + Database.Addhar);
            System.out.println(" :-Room Number-: " + Database.RoomNo.get(Database.Decider));
            System.out.println(" :-Room Type---: " + Database.RoomType.get(Database.Decider));
            System.out.println(" :-Room Price--: " + Database.RoomPrice.get(Database.Decider));
            Server.sc.next();
            FrontEnd.MainMenu();
        }
    }

    public static void CancelBooking() {
        try {
            System.out.println(" : Enter Your Room Number :");
            Database.UserRoomNo = Server.sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(" : InputMismatchException : \n : Enter Integer Value :");
            Database.UserRoomNo = Server.sc.nextInt();
        }
        Server.FindRoom(Database.UserRoomNo);
        if (Database.RoomAvailability.get(Database.Decider)) {
            System.out.println(" : Room SuccessFully Cancelled :");
            Database.RoomAvailability.set(Database.Decider, true);
            FrontEnd.MainMenu();
        } else {
            System.out.println(" : Room is Not Booked Yet :");
            FrontEnd.MainMenu();
        }
    }
}

class App {
    public void Install() {
        Preload();
        Packages();
        Procedure();
    }

    public static void Uninstall() {
        try {
            System.out.println("Uninstalling packages...");
            // Thread.sleep(2000);
            Animation();
            System.out.println("Synchronizing Server...");
            // Thread.sleep(2000);
            Animation();
            System.out.println("Uninstalling Textures...");
            // Thread.sleep(2000);
            Animation();
            System.out.println("Uninstalling Resources,Models...");
            // Thread.sleep(2000);
            Animation();
            System.out.println("Uninstalling Fonts...");
            // Thread.sleep(2000);
            Animation();
            System.out.println("Uninstalling Images...");
            // Thread.sleep(2000);
            Animation();
            System.out.println("Uninstalling UI Elements...");
            Animation();
            System.out.println("Freeing Resources And  Memory...");
            Animation();
            System.out.println("Closing...");
            Animation();
            System.exit(0);
        } catch (Exception e) {
            System.out.println(" : Error : " + e);
        }
    }

    public static void Animation() {
        // System.out.println("Enter:");
        for (int i = 0; i < 10; i++) {
            switch (i % 4) {
                case 0:
                    System.out.print("|");
                    break;
                case 1:
                    System.out.print("\\");
                    break;
                case 2:
                    System.out.print("--");
                    break;
                case 3:
                    System.out.print("/");
                    break;
            }
            Server.sleep(500);
            System.out.print("\r"); // Move the cursor to the beginning of the line
        }
    }

    public static void Preload() {
        Server.Initialize();
    }

    public static void Procedure() {
        FrontEnd.MainMenu();
    }

    public static void Packages() {
        try {
            System.out.println("Loading packages...");
            // Thread.sleep(2000);
            Animation();
            System.out.println("Synchronizing Server...");
            // Thread.sleep(2000);
            Animation();
            System.out.println("Loading Textures...");
            // Thread.sleep(2000);
            Animation();
            System.out.println("Loading Resources,Models...");
            // Thread.sleep(2000);
            Animation();
            System.out.println("Loading Fonts...");
            // Thread.sleep(2000);
            Animation();
            System.out.println("Loading Images...");
            // Thread.sleep(2000);
            Animation();
            System.out.println("Loading UI Elements...");
            Animation();
        } catch (Exception e) {
            System.out.println(" : Error : " + e);
        }
    }
}
/*
 * Hotel Reservation System
 * class : Server , Database , Frontend , BackEnd , App
 * User-data : email,phone,age,name,gender,addhar
 * Hotel Room : Variables : room number,type,availability,price
 * Options : Book And Cancel Room ,able to Traverse Rooms
 * additional variables : Decider,converter
 */