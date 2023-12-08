package proj.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import proj.entity.enums.UserRole;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "`password`")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", columnDefinition = "ENUM('CUSTOMER', 'ADMIN', 'CASHIER')")
    private UserRole userRole;

//    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)//, fetch = FetchType.EAGER)
    private List<Order> orders;

}

