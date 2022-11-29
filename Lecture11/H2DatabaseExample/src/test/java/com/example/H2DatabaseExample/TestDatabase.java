package com.example.H2DatabaseExample;

import static org.junit.jupiter.api.Assertions.*;

import com.example.H2DatabaseExample.beans.Avenger;
import com.example.H2DatabaseExample.database.DatabaseAccess;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.util.List;

@SpringBootTest
public class TestDatabase {

    private DatabaseAccess da;

    @Autowired
    public void setDa(DatabaseAccess da){
        this.da=da;
    }

    @Test
    public void testDatabaseAd(){
        Avenger avenger = new Avenger();
        avenger.setName("Starlord");
        avenger.setAge(30);

        int origSize = da.getAvengers().size();

        da.addAvenger(avenger);
        int newSize = da.getAvengers().size();

        assertEquals(newSize, origSize + 1);
    }

    @Test
    public void testDatabaseList(){
        Avenger avenger = new Avenger();
        avenger.setName("Starlord");
        avenger.setAge(30);

        da.addAvenger(avenger);

        List<Avenger> avengers = da.getAvengers();

        assertTrue(avengers != null);
    }

    @Test
    public void testDatabaseDelete(){

        List<Avenger> avengers = da.getAvengers();

        Long id = avengers.get(0).getId();

        int origSize = da.getAvengers().size();

        da.deleteAvenger(id);
        int newSize = da.getAvengers().size();

        assertEquals(newSize, origSize-1);

    }


}
