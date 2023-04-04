package hr.donata.carservice.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class HomePageController {


    @GetMapping
    private ResponseEntity<String> getHomePage() {
        return ResponseEntity.ok("Hello! Welcome to car Service app");

    }



}
