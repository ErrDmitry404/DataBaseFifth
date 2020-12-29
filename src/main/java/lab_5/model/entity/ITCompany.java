package lab_5.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Scanner;

@Data
@Entity
@Table(name = "itcompany")
@Accessors(chain = true)
@NoArgsConstructor
public class ITCompany {


    private static final Scanner SCANNER = new Scanner(System.in);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "companyConfiguration")
    private String companyConfiguration;

    @Column(name = "typeOfDevices")
    private String typeOfDevices;

    @Column(name = "serverId")
    private Integer serverId;

    @Column(name = "workersId")
    private Integer workersId;

    public ITCompany(String companyConfiguration, String typeOfDevices, Integer serverId, Integer workersId) {
        this.companyConfiguration = companyConfiguration;
        this.typeOfDevices = typeOfDevices;
        this.serverId = serverId;
        this.workersId = workersId;
    }

}
