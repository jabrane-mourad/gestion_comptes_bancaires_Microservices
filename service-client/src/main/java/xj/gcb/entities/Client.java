package xj.gcb.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer code_utilisateur;
    private String cin;
    private String prenom;
    private String nom;
    private String telephone;
    private String ville;
    private String email;
    private Date date_naissance;
}
