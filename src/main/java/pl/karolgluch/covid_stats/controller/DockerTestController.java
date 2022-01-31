package pl.karolgluch.covid_stats.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerTestController {

    @GetMapping("/hello-docker")
    public String helloDocker() {
        return "Hello Docker!";
    }
}
