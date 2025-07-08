import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        
        Cheese cheese = new Cheese("Cheese", 100, 10, LocalDate.now().plusDays(5), 0.2);

        Biscuits biscuits = new Biscuits("Biscuits", 150, 5, LocalDate.now().plusDays(2), 0.7);

        TV tv = new TV("TV", 5000, 3, 8.0);

        Mobile mobile = new Mobile("Mobile", 2000, 5);

        ScratchCard scratchCard = new ScratchCard("ScratchCard", 50, 100);

        Customer customer = new Customer("Abdulrahman", 20000);

        Cart cart = new Cart();
        cart.add(biscuits, 2);
        cart.add(tv, 3);
        cart.add(scratchCard, 1);


        try {
        
            CheckoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Checkout error: " + e.getMessage());
        }
    }
}