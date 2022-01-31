package pl.karolgluch.covid_stats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.karolgluch.covid_stats.model.CovidStats;
import pl.karolgluch.covid_stats.service.CovidStatsService;

@RestController
public class CovidStatsController {

    @Autowired
    private CovidStatsService covidStatsService;

    @GetMapping({"/", "/index"})
    public CovidStats index() {
        return covidStatsService.getTodayCovidStatistics();
    }
}
