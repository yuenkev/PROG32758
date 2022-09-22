package ca.sheridancollege.lokbokexample.beans;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;


@Component
@Data
@AllArgsConstructor
public class School {

    private String name;
    private String address;
    private int numStudents;

    public School(){
        this("Sheridan", "Oakville", 23000);
    }

    //original way if u wanna add 2 param constructors
    public School(String name, String address){
        this.name = name;
        this.address = address;
    }






}
