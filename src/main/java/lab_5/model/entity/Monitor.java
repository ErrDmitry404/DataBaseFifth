package lab_5.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Scanner;

@Data
@Entity
@Table(name = "monitor")
@Accessors(chain = true)
@NoArgsConstructor
public class Monitor {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "monitorsResolution")
    private String monitorsResolution;

    @Column(name = "model")
    private String model;


//    private Integer id;
//    private String monitorsResolution;
//    private String model;

    public Monitor(String monitorsResolution, String model) {
        this.monitorsResolution = monitorsResolution;
        this.model = model;
    }
}
