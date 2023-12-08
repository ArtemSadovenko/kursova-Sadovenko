package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.entity.*;
import proj.entity.enums.UserRole;
import proj.repo.UserRepository;
import proj.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserServiceImpl service;

    @PostMapping("/sign-up")
    public void singUp(@RequestBody User user){
        service.signUp(user);
    }

    @PostMapping("/{id}/makeOrder")
    public void makeOrder(@RequestBody OrderDto order, @PathVariable Long id){
        service.makeOrder(order, id);
    }

    @GetMapping("/test")
    public User test(){
        return service.getAll().stream().filter(e -> e.getId() == 1).findFirst().get();
    }

    @PostMapping("/admin/{id}/cashier")
    public String createCashier(@RequestBody User cashier, @PathVariable Long id){
        if (service.get(id).getUserRole().equals(UserRole.ADMIN)){
            service.createCashier(cashier);
            return "Done Successfully";
        }
        else {
            return "Only Admin can add new Cashier";
        }
    }

    @GetMapping("/admin/{id}/all")
    public List<User> getAllUsers(@PathVariable Long id){
        return service.get(id).getUserRole().equals(UserRole.ADMIN) ? service.getAll() : List.of();
    }

    @PostMapping("/admin/{id}/newCoffee")
    public String createCoffee(@RequestBody Coffee coffee, @PathVariable Long id){
        if (service.get(id).getUserRole().equals(UserRole.ADMIN)){
            service.addCoffee(coffee);
            return "Done Successfully";
        }
        else {
            return "Only Admin can add new MenuItem";
        }
    }

    @PostMapping("/admin/{id}/newTopping")
    public String createTopping(@RequestBody Topping topping, @PathVariable Long id){
        if (service.get(id).getUserRole().equals(UserRole.ADMIN)){
            service.addTopping(topping);
            return "Done Successfully";
        }
        else {
            return "Only Admin can add new MenuItem";
        }
    }

    @GetMapping("/menu")
    public String menu(){
        return service.menu();
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return service.getAllOrders();
    }

    @PatchMapping("/cashier/{id}/updateStatus")
    public String updateOrderStatus(@PathVariable Long id,@RequestBody Order order){
        if (service.get(id).getUserRole().equals(UserRole.CASHIER)){
            service.updateOrder(order);
            return "Done Successfully";
        }
        else {
            return "Only Admin can add new MenuItem";
        }
    }

    @GetMapping("/{id}/orders")
    public List<Order> checkUserOrder(@PathVariable Long id){
        return service.get(id).getOrders();
    }

}
