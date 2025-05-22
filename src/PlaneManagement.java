public class PlaneManagement {

    private static Ticket[] tickets = new Ticket[52];

    public static void main(String[] args) {
        Functions functions = new Functions();
        Seats seats = new Seats();

        System.out.println("Welcome to Plane Management Application!");
        //options has the user menu item index that the user selects
        while (true) {
            int option = functions.userMenu();
            switch (option) {
                case 1 -> {
                    Ticket ticket = new Ticket();
                    ticket = functions.buySeat();
                    tickets[ticket.getId() - 1] = ticket;
                }
                case 2 -> functions.cancelSeat(tickets);
                case 3 -> functions.findFirstAvailableSeat();
                case 4 -> seats.displaySeats();
                case 5 -> functions.printTickets(tickets);
                case 6 -> functions.searchTicket(tickets);
                case 7 -> System.exit(0);
                default -> System.out.println("Invalid option");
            }
        }

    }
}
