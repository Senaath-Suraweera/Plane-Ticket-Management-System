import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



//every parsing data to lowercase
public class Functions {
    Seats seats = new Seats();


    public boolean rangeValidation(int row, int seat) {
        return switch (row) {
            case 0, 3 -> seat > 0 && seat <= 14;
            case 1, 2 -> seat > 0 && seat <= 12;
            default -> false;
        };
    }

    public int seatRowIndex(char c) {
        return switch (c) {
            case 'a' -> 0;
            case 'b' -> 1;
            case 'c' -> 2;
            case 'd' -> 3;
            default -> -1;
        };
    }

    public char seatRowIndexInverse(int n){
        return switch (n){
            case 0 -> 'A';
            case 1 -> 'B';
            case 2 -> 'C';
            case 3 -> 'D';
            default -> throw new IllegalStateException("Unexpected value: " + n);
        };
    }

    public Person getPerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Your First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Please Enter Your Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println("Please Enter Your Email: ");
        String email = scanner.nextLine();
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmail(email);
        return person;
    }

    public Ticket generateTicket(String row, int seat,Person person) {
        int bias = 0;
        switch (row) {
            case "A"-> bias = 0;
            case "B"-> bias = 14;
            case "C"-> bias = 26;
            case "D"-> bias = 38;
        }
        Ticket ticket = new Ticket();
        ticket.setSeat(seat);
        ticket.setRow(row);
        ticket.setId(seat + bias);
        ticket.setPerson(person);
        return ticket;
    }

    public Ticket buySeat() {
        int seatNumber;
        char row;
        Scanner input1 = new Scanner(System.in);

        seats.displaySeats();
        System.out.println("Seats displayed with a \"0\" are available while seats displayed with an \"X\" are not.");
        System.out.println();

        System.out.println("Enter the ROW LETTER of the seat you would like to purchase: ");
        String regex = "^[a-zA-Z]$";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            String seat = input1.nextLine().trim().toLowerCase();
            Matcher matcher = pattern.matcher(seat);
            if (matcher.matches()) {
                row = seat.charAt(0);
                break;
            } else {
                System.out.println("Invalid ROW LETTER!! Please enter a single letter (e.g., A, B, C).");
            }
        }

        int seatRow = seatRowIndex(row);
        Scanner input2 = new Scanner(System.in);

        System.out.println("Enter the SEAT NUMBER of the seat you would like to purchase: ");
        while (true) {
            if (input2.hasNextInt()) {
                seatNumber = input2.nextInt();
                if (rangeValidation(seatRow, seatNumber)) {
                    break;
                } else {
                    System.out.println("Invalid SEAT NUMBER!");
                }
            } else {
                System.out.println("Enter a valid seat number!!");
                input2.nextLine();
            }
        }

        Person person = getPerson();
        Ticket ticket = generateTicket(String.valueOf(row),seatNumber,person);

        // implement a way to exit out of the input prompt

        seats.setSeat(seatRow, seatNumber);

        System.out.println("Seat has been purchased!");

        seats.displaySeats();

        return ticket;

    }

    public void cancelSeat(Ticket[] ticket) {
        int seatNumber;
        char row;
        Scanner input1 = new Scanner(System.in);

        seats.displaySeats();
        System.out.println("Seats displayed with a \"0\" are available while seats displayed with an \"X\" are not.");
        System.out.println();

        System.out.println("Enter the ROW LETTER of the seat you would like to cancel the seat of: ");
        String regex = "^[a-zA-Z]$";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            String seat = input1.nextLine().trim().toLowerCase();
            Matcher matcher = pattern.matcher(seat);
            if (matcher.matches()) {
                row = seat.charAt(0);
                break;
            } else {
                System.out.println("Invalid ROW LETTER!! Please enter a single letter (e.g., A, B, C).");
            }
        }

        int seatRow = seatRowIndex(row);
        Scanner input2 = new Scanner(System.in);

        System.out.println("Enter the SEAT NUMBER of the seat you would like to purchase: ");
        while (true) {
            if (input2.hasNextInt()) {
                seatNumber = input2.nextInt();
                if (rangeValidation(seatRow, seatNumber)) {
                    break;
                } else {
                    System.out.println("Invalid SEAT NUMBER!");
                }
            } else {
                System.out.println("Enter a valid seat number!!");
                input2.nextLine();
            }
        }

        int bias = 0;
        switch (row) {
            case 'A'-> bias = 0;
            case 'B'-> bias = 14;
            case 'C'-> bias = 26;
            case 'D'-> bias = 38;
        }



        if(seats.getSeat(seatRow,seatNumber) == 1){

            ticket[bias - 1] = null;

            seats.deleteSeat(seatRow, seatNumber);

            System.out.println("Seat has been cancelled!");

            seats.displaySeats();
        }else{
            System.out.println("Seat has not been booked to cancel!");
            //using recursion fix later
            cancelSeat(ticket);
        }

    }

    public void findFirstAvailableSeat(){
        int[] seatNumbers = seats.findFirstAvailableSeat();
        System.out.println("The first available seat is " + seatRowIndexInverse(seatNumbers[0]) + " " + seatNumbers[1]);
    }

    public void printTickets(Ticket[] tickets){
        for (Ticket ticket : tickets) {
            System.out.println(ticket.toString());
        }
    }

    public void searchTicket(Ticket[] ticket) {
        int seatNumber;
        char row;
        Scanner input1 = new Scanner(System.in);

        seats.displaySeats();
        System.out.println("Seats displayed with a \"0\" are available while seats displayed with an \"X\" are not.");
        System.out.println();

        System.out.println("Enter the ROW LETTER of the seat you would like to purchase: ");
        String regex = "^[a-zA-Z]$";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            String seat = input1.nextLine().trim().toLowerCase();
            Matcher matcher = pattern.matcher(seat);
            if (matcher.matches()) {
                row = seat.charAt(0);
                break;
            } else {
                System.out.println("Invalid ROW LETTER!! Please enter a single letter (e.g., A, B, C).");
            }
        }

        int seatRow = seatRowIndex(row);
        Scanner input2 = new Scanner(System.in);

        System.out.println("Enter the SEAT NUMBER of the seat you would like to purchase: ");
        while (true) {
            if (input2.hasNextInt()) {
                seatNumber = input2.nextInt();
                if (rangeValidation(seatRow, seatNumber)) {
                    break;
                } else {
                    System.out.println("Invalid SEAT NUMBER!");
                }
            } else {
                System.out.println("Enter a valid seat number!!");
                input2.nextLine();
            }
        }

        boolean found = false;
        for(Ticket tickets: ticket){
            System.out.println("Ticket Found: " + tickets);
            found = true;
            break;
        }
        if(!found){
            System.out.println("Ticket not found for seat" + seatRowIndexInverse(seatRow) + " " + seatNumber);
        }

    }


    public int userMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("******************************************");
        System.out.println("*                  MENU                  *");
        System.out.println("******************************************");
        System.out.println("     1) Buy a seat");
        System.out.println("     2) Cancel a seat");
        System.out.println("     3) Find first available seat");
        System.out.println("     4) Show seating plan");
        System.out.println("     5) Print tickets information and total sales");
        System.out.println("     6) Search ticket");
        System.out.println("     7) Quit");
        System.out.println("******************************************");
        System.out.println("Please select an option: ");
        while (true) {
            if(scanner.hasNextInt()) {
                return scanner.nextInt();
            }else{
                scanner.nextLine();
                System.out.println("Invalid input. Try again.");
                System.out.println("Please select an option: ");
            }
        }
    }
}
