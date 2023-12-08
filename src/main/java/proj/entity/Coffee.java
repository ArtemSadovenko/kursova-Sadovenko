package proj.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coffees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`description`")
    private String description;

    @Column(name = "price")
    private Double price;


    @Override
    public String toString() {
        return name +'\n'+
                price +'\n'+
                description +"\n\n";
    }
}

