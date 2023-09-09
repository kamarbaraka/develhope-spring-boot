package com.develhope.develhopespringboot.app.excercise1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
