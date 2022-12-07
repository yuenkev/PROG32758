package ca.sheridan.nov02.beans;


import lombok.Data;
// MUST add this import to specify the table name
import org.springframework.data.relational.core.mapping.Table;
import javax.persistence.*;

// Adds getters and setters
@Data
// Builds our model object for us
// generates a constructor with 1 parameter for each field in your class.
@Entity
@Table (name = "Users")
public class Bob {

    @Id
    private Long id;
    private String name;
    private String email;
    private String address;


}
