package com.backend.backendkalceto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoveMeController {

    @GetMapping("/login")
    public void removeMe() { }

}
