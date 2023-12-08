package proj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.entity.*;
import proj.entity.enums.OrderStatus;
import proj.entity.enums.UserRole;
import proj.repo.CoffeeRepository;
import proj.repo.OrderRepository;
import proj.repo.ToppingRepository;
import proj.repo.UserRepository;
import proj.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CoffeeRepository coffeeRepository;

    @Autowired
    ToppingRepository toppingRepository;

    @Override
    public String signUp(User user) {
        user.setUserRole(UserRole.CUSTOMER);
        userRepository.save(user);
        return "Signed Up";
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void addCoffee(Coffee coffee) {
        coffeeRepository.save(coffee);
    }

    @Override
    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll();
    }

    @Override
    public Coffee getCoffeeById(Long id) {
        return coffeeRepository.findById(id).get();
    }

    @Override
    public void addTopping(Topping topping) {
        toppingRepository.save(topping);
    }

    @Override
    public List<Topping> getAllTopping() {
        return toppingRepository.findAll();
    }

    @Override
    public Topping getToppingById(Long id) {
        return toppingRepository.findById(id).get();
    }

    @Override
    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void updateOrder(Order order) {
        Order old = orderRepository.findById(order.getId()).get();
        old.setOrderStatus(order.getOrderStatus());
        orderRepository.save(old);
    }

    @Override
    public Order getOrderById(Long Id) {
        return orderRepository.findById(Id).get();
    }

    @Override
    public String createCashier(User user) {
        user.setUserRole(UserRole.CASHIER);
        userRepository.save(user);
        return "Signed Up a Cashier";
    }

    @Override
    public void makeOrder(OrderDto dto, Long id) {
        Order order = new Order();
        order.setCoffee(
                coffeeRepository.findAll().stream()
                        .filter(coffee -> coffee.getName().equals(dto.getCoffee()))
                        .findFirst().get()
        );
        order.setTopping(
                toppingRepository.findAll().stream()
                        .filter(topping -> topping.getName().equals(dto.getTopping()))
                        .findFirst().get()
        );
        order.setOrderStatus(OrderStatus.OPENED);

//                .coffee(
//                        coffeeRepository.findAll().stream()
//                                .filter(coffee -> coffee.getName().equals(dto.getCoffee()))
//                                .findFirst().get()
//                )
//                .topping(
//                        toppingRepository.findAll().stream()
//                                .filter(topping -> topping.getName().equals(dto.getTopping()))
//                                .findFirst().get()
//                )
//                .user(userRepository.findById(id).get())
//                .orderStatus(OrderStatus.OPENED)
//                .build();
        order.setUser(userRepository.findById(id).get());
        order.setPrice(order.getCoffee().getPrice() + order.getTopping().getPrice());
        orderRepository.save(order);
    }

    @Override
    public String menu() {
//        return new StringBuilder()
//                .append("Coffee: \n")
//                .append(coffeeRepository.findAll().stream()
//                        .map(Coffee::toString)
//                        .collect(Collectors.toList()).toString())
//                .append("Topping: \n")
//                .append(toppingRepository.findAll().stream()
//                        .map(Topping::toString)
//                        .collect(Collectors.toList()).toString())
//                .toString();
        return new StringBuilder()
                .append("Coffee: \n")
                .append(coffeeRepository.findAll().stream()
                        .map(Coffee::toString)
                        .collect(Collectors.joining()))
                .append("Topping: \n")
                .append(toppingRepository.findAll().stream()
                        .map(Topping::toString)
                        .collect(Collectors.joining()))
                .toString();
    }


}
