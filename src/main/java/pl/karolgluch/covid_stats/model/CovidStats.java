package pl.karolgluch.covid_stats.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CovidStats {
    private String date;
    private String confirmedToday;
    private String deathsToday;
    private String totalConfirmed;
    private String totalDeaths;
}
