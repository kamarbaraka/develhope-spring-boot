package com.develhope.develhopespringboot.app.excercise1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * the hello controller.
 * @author kamar baraka.*/

@RestController
@RequestMapping(value = {"/api/"})
public class HelloController {

    /*Exercise 1*/
    @GetMapping(value = {"hello"})
    public ResponseEntity<String > hello(){

        return new ResponseEntity<>("hello world", HttpStatus.OK);
    }

    /*Exercise 2*/
    @GetMapping(value = {"greeting"})
    public ResponseEntity<String > greeting(){

        /*return the greeting*/
        return new ResponseEntity<>("good morning", HttpStatus.OK);
    }

    /*Exercise 3*/
    @GetMapping(value = {"info"})
    public ResponseEntity<String > info(){

        return new ResponseEntity<>("", HttpStatus.OK);
    }

    /*Exercise 4*/
    @GetMapping(value = {"random"})
    public ResponseEntity<String> random(){

        if (new Random().nextBoolean())
            return new ResponseEntity<>("true", HttpStatus.OK);

        return new ResponseEntity<>("false", HttpStatus.BAD_REQUEST);
    }
}
