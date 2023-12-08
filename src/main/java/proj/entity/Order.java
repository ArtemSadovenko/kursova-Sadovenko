package proj.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import proj.entity.enums.OrderStatus;
import proj.entity.enums.UserRole;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "coffee_id")
    private Coffee coffee;

    @ManyToOne
    @JoinColumn(name = "topping_id")
    private Topping topping;

    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", columnDefinition = "ENUM('OPENED', 'PREPARING','DONE','CLOSED')")
    private OrderStatus orderStatus;
}

