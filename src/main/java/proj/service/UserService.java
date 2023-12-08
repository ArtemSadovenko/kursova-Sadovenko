package proj.service;

import proj.entity.*;

import java.util.List;

public interface UserService {
    //user
    String signUp(User user);

    void update(User user);

    List<User> getAll();

    User get(Long id);

    //coffee
    void addCoffee(Coffee coffee);

    List<Coffee> getAllCoffee();

    Coffee getCoffeeById(Long id);

    //topping
    void addTopping(Topping topping);

    List<Topping> getAllTopping();

    Topping getToppingById(Long id);

    //order

    void createOrder(Order order);

    List<Order> getAllOrders();

    void updateOrder(Order order);

    Order getOrderById(Long Id);

    //admin
    String createCashier(User user);

    void makeOrder(OrderDto dto, Long id);

    String menu();
}
