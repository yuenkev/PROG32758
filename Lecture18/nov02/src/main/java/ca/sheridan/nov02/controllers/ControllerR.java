package ca.sheridan.nov02.controllers;

import ca.sheridan.nov02.Database.DatabaseAccess;
import ca.sheridan.nov02.beans.Bob;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/restController")
public class ControllerR {
    private DatabaseAccess da;

    //testing to see if we get a response --> REST AP???

    @GetMapping("/userss")
    // can accept anytype of obj. <?> WILDCARD
    public ResponseEntity<?> getUsers() {

        List<Bob> bobs = da.getUsers();

        if (bobs != null) {
            return ResponseEntity.ok(bobs);
        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No record found");
        }
    }


    //return adding a user
    @PostMapping ("/user")
    public ResponseEntity<?> postStudent(@RequestBody Bob user){

        try{
            Long id = da.addUser(user);

            user.setId(id);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(id).toUri();

            return ResponseEntity.created(location).body(user);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Name already exists.");
        }
    }




}
