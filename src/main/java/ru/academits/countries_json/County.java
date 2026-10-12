package ru.academits.countries_json;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class County {
    private String name;
    private int population;
    private List<Currency> currencies;

    private final Map<String, Object> ignoredFields = new HashMap<>();

    public County(String name, int population, List<Currency> currencies) {
        this.name = name;
        this.population = population;
        this.currencies = currencies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    @JsonAnySetter
    public void setUnknownField(String key, Object value) {
        this.ignoredFields.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getUnknownFields() {
        return this.ignoredFields;
    }
}
