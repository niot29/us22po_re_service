package se.us22po.us22po_re_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@Table(name = "RECOMMENDATION")
public class RecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;
    private int productId;
    private String email;

    // max charaters 1000
    @Column(length=1001)
    private String comment;
    private int rating;

    // status for publish comment
    private int status;


    public RecoEntity() {

    }

    public RecoEntity(int id, String productName, int productId, int categoryID, String email, String comment, int rating, int status) {
        this.id = id;
        this.productName = productName;
        this.productId = productId;
        this.email = email;
        this.comment = comment;
        this.rating = rating;
        this.status = status;
    }
}
