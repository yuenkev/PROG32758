package ca.sheridancollege.lokbokexample.database;

import ca.sheridancollege.lokbokexample.beans.School;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Data
public class DatabaseAccess {

    private ArrayList<School> schoolList = new ArrayList<>();

}
