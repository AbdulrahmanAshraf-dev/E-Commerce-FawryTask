import java.util.*;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        double subtotal = 0;
        double shipping = 0;
        List<Shippable> toShip = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.product;
            if (item.quantity > product.getQuantity()) {
                throw new IllegalStateException(product.getName() + " is out of stock");
            }
            if (product.isExpired()) {
                throw new IllegalStateException(product.getName() + " is expired");
            }
            subtotal += product.getPrice() * item.quantity;
            if (product.isShippable()) {
                for (int i = 0; i < item.quantity; i++) {
                    toShip.add((Shippable) product);
                }
            }
        }

        if (!toShip.isEmpty()) {
            shipping = 30; 
            ShippingService.ship(toShip);
        }

        double total = subtotal + shipping;
        if (customer.getBalance() < total) {
            throw new IllegalStateException("Customer's balance is insufficient.");
        }

        customer.deduct(total);
        for (CartItem item : cart.getItems()) {
            item.product.reduceQuantity(item.quantity);
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s %.0f\n", item.quantity, item.product.getName(), item.product.getPrice() * item.quantity);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shipping);
        System.out.printf("Amount %.0f\n", total);
        System.out.printf("Customer balance after payment: %.0f\n", customer.getBalance());
    }
}