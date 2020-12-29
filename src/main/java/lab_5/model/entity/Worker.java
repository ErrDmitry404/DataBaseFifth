package lab_5.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Scanner;

@Data
@Entity
@Table(name = "worker")
@Accessors(chain = true)
@NoArgsConstructor
public class Worker {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "AgeId")
    private Integer AgeId;


//    private Integer id;
//    private String fullName;
//    private Integer amount;
//    private Integer AgeId;

    public Worker(String fullName, Integer amount, Integer irPhonesId) {
        this.fullName = fullName;
        this.amount = amount;
        this.AgeId = AgeId;
    }
}
