package lab_5.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Scanner;
import java.util.Set;

@Data
@Entity
@Table(name = "event")
@Accessors(chain = true)
@NoArgsConstructor

public class IrPhones {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "phoneTypes")
    private String phoneTypes;

    @OneToOne
    @JoinColumn(name = "phoneModel", referencedColumnName = "id", nullable = false)
    private String phoneModel;

    @OneToOne
    @JoinColumn(name = "phone_id", referencedColumnName = "id", nullable = false)
    private Integer phoneId;


//    private Integer id;
//    private String phoneTypes;
//    private String phoneModel;

    public IrPhones(String phoneTypes, String phoneModel, Integer phoneId) {
        this.phoneTypes = phoneTypes;
        this.phoneModel = phoneModel;
        this.phoneId = phoneId;
    }
}
