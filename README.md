# Fawry-Task
# E-Commerce System

Welcome! This is a simple e-commerce system built in Java, designed to show how you can handle different types of products, carts, shipping, and checkout logic in a real-world scenario. The code is clean, easy to follow, and ready for you to extend or use as a learning reference.

## What This Project Does
- Lets you define products with a name, price, and available quantity.
- Handles products that can expire (like Cheese and Biscuits) and those that don't (like TVs and Mobiles).
- Supports shippable products (like Cheese and TVs) with weights, and non-shippable items (like mobile scratch cards).
- Customers can add products to their cart, but not more than what's in stock.
- Checkout process checks for expired or out-of-stock items, calculates totals, shipping, and updates the customer's balance.
- If there are shippable items, it prints a shipping notice with the total package weight.

## How It Works (In Plain English)
1. **Products**: Each product knows its name, price, quantity, and whether it can expire or be shipped. Shippable products have a weight.
2. **Cart**: Customers add products to their cart. The system makes sure you can't add more than what's available.
3. **Checkout**: When you checkout, the system:
   - Checks for errors (empty cart, expired items, not enough stock, or not enough money).
   - Calculates the subtotal and shipping (if needed).
   - Deducts the right quantities and updates the customer's balance.
   - Prints a clear receipt and, if needed, a shipping notice.

## Example: See It in Action
Here's a quick example of how you might use the system in your code:

```java
Cheese cheese = new Cheese("Cheese", 100, 10, false, 0.4);
Biscuits biscuits = new Biscuits("Biscuits", 150, 5, true, 0.7);
TV tv = new TV("TV", 5000, 3, 10.0);
Mobile mobile = new Mobile("Mobile", 2000, 5);
ScratchCard scratchCard = new ScratchCard("ScratchCard", 50, 100);

Customer customer = new Customer("Ali", 1000);
Cart cart = new Cart();
cart.add(cheese, 2);
cart.add(biscuits, 1);
cart.add(scratchCard, 1);

new CheckoutService().checkout(customer, cart);
```

And here's what you'll see in the console:

```
** Shipment notice **
2x Cheese 400g
1x Biscuits 700g
Total package weight 1.1kg
** Checkout receipt **
2x Cheese 200
1x Biscuits 150
1x ScratchCard 50
----------------------
Subtotal 400
Shipping 30
Amount 430
Customer balance 570
```

## Assumptions & Notes
- Shipping is a flat fee per order if there's anything to ship (you can change this to per kg if you want).
- The system checks for expired products at checkout.
- Product stock is updated only after a successful checkout.
- All the usual errors (empty cart, not enough money, expired or out-of-stock products) are handled gracefully.

## How to Run It
1. Copy the Java classes into your project.
2. Use the example above in your `Main` class to try it out.
3. Change the products, customer balance, or cart contents to test different scenarios.

---

Feel free to play around, extend it, or use it as a base for your own e-commerce ideas. If you have questions or want to add features, just jump in and start coding!
![Screenshot 2025-07-08 211912](https://github.com/user-attachments/assets/7dd2606e-ae5c-4d70-babf-d94ab1eecb7a)
![Screenshot 2025-07-08 211911](https://github.com/user-attachments/assets/24673979-4505-4d94-a1c0-9a5496877c54)
