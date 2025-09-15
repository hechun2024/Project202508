// 5.2_1 Implement a ticket reservation system where multiple threads (customers) try to reserve tickets from
// a limited pool of available seats.
// Use synchronization to ensure that no more tickets are sold than are available.
class TicketReservation {
    private int availableSeats;

    public TicketReservation(int seats) {
        this.availableSeats = seats;
    }

    // synchronized: only one thread can try reserving at a time
    public synchronized boolean reserve(String customer, int tickets) {
        if (tickets <= availableSeats) {
            System.out.println(customer + " reserved " + tickets + " tickets.");
            availableSeats -= tickets;
            return true;
        } else {
            System.out.println(customer + " couldn't reserve " + tickets + " tickets.");
            return false;
        }
    }
}

// Customer = Thread
class Customer extends Thread {
    private TicketReservation system;
    private int tickets;

    public Customer(TicketReservation system, String name, int tickets) {
        super(name); // set thread name， 调用 Thread(String name) 构造函数
        this.system = system;
        this.tickets = tickets;
    }

    public void run() {
        system.reserve(getName(), tickets);
    }
}

public class MainTask1 {
    public static void main(String[] args) {
        TicketReservation system = new TicketReservation(10); // total seats

        // create customers (threads)
        Customer[] customers = {
                new Customer(system, "Customer 1", 2),
                new Customer(system, "Customer 2", 1),
                new Customer(system, "Customer 3", 3),
                new Customer(system, "Customer 4", 1),
                new Customer(system, "Customer 5", 2),
                new Customer(system, "Customer 6", 2),
                new Customer(system, "Customer 7", 1),
                new Customer(system, "Customer 8", 1),
                new Customer(system, "Customer 9", 3),
                new Customer(system, "Customer 10", 3),
        };

        // start customers
        for (Customer c : customers) {
            c.start();
        }
    }
}
