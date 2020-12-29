package lab_5.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Scanner;
import java.util.Set;

@Data
@Entity
@Table(name = "server")
@Accessors(chain = true)
@NoArgsConstructor
public class Server {


    private static final Scanner SCANNER = new Scanner(System.in);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "onlineNow")
    private String onlineNow;

    @OneToMany(mappedBy = "serversId", fetch = FetchType.EAGER)
    private Server serversId;


//    private Integer id;
//    private String onlineNow;
//    private Integer monitorsId;


    public Server(Server serversId) {
        this.serversId = serversId;
    }
}