package pl.karolgluch.covid_stats.service;

import pl.karolgluch.covid_stats.model.CovidStats;

public interface CovidStatsService {
    CovidStats getTodayCovidStatistics();
}
