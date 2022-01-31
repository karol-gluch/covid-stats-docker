package pl.karolgluch.covid_stats.service.impl;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.karolgluch.covid_stats.model.CovidStats;
import pl.karolgluch.covid_stats.service.CovidStatsService;

import java.io.StringReader;

import static pl.karolgluch.covid_stats.helper.DateHelper.*;

@Service
public class CovidStatsServiceImpl implements CovidStatsService {

    private static final String URL_INFECTIONS_COVID = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private static final String URL_DEATHS_COVID = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv";
    private static final String COUNTRY_REGION = "Country/Region";
    private static final String POLAND = "Poland";

    @Override
    public CovidStats getTodayCovidStatistics() {
        CovidStats covidStats = new CovidStats();
        try {
            StringReader stringReaderConfirmed = new StringReader(getStatisticsFromUrlCsvFile(URL_INFECTIONS_COVID));
            StringReader stringReaderDeath = new StringReader(getStatisticsFromUrlCsvFile(URL_DEATHS_COVID));

            CSVParser parserConfirmed = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReaderConfirmed);
            CSVParser parserDeaths = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReaderDeath);

            setConfirmedToCovidStats(parserConfirmed, covidStats);
            setDeathsToCovidStats(parserDeaths, covidStats);
            covidStats.setDate(getDateToResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return covidStats;
    }

    private String getStatisticsFromUrlCsvFile(String url) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Error occurred while getting data from url: " + url);
        }
    }

    private void setConfirmedToCovidStats(CSVParser confirmed, CovidStats covidStats) {
        for (CSVRecord record : confirmed) {
            String country = record.get(COUNTRY_REGION);

            if (country.equals(POLAND)) {
                String totalConfirmedToday = record.get(getTodayDate());
                String totalConfirmedYesterday = record.get(getYesterdayDate());

                int statsToday = Integer.parseInt(totalConfirmedToday) - Integer.parseInt(totalConfirmedYesterday);
                covidStats.setTotalConfirmed(totalConfirmedToday);
                covidStats.setConfirmedToday(String.valueOf(statsToday));
            }
        }
    }

    private void setDeathsToCovidStats(CSVParser deaths, CovidStats covidStats) {
        for (CSVRecord record : deaths) {
            String country = record.get(COUNTRY_REGION);

            if (country.equals(POLAND)) {
                String totalDeathsToday = record.get(getTodayDate());
                String totalDeathsYesterday = record.get(getYesterdayDate());

                int statsToday = Integer.parseInt(totalDeathsToday) - Integer.parseInt(totalDeathsYesterday);
                covidStats.setTotalDeaths(totalDeathsToday);
                covidStats.setDeathsToday(String.valueOf(statsToday));
            }
        }
    }
}
