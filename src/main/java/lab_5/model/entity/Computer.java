package lab_5.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Scanner;

@Data
@Entity
@Table(name = "computer")
@Accessors(chain = true)
@NoArgsConstructor
public class Computer {

    private static final Scanner scanner = new Scanner(System.in);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "monitorsID")
    private Integer monitorsId;




    //private Integer id;
    //private Integer amount;
    //private String manufacturer;
    //private Integer monitorsId;

    public Computer(Integer amount, String manufacturer, Integer monitorsId) {
        this.amount = amount;
        this.manufacturer = manufacturer;
        this.monitorsId = monitorsId;
    }

}
