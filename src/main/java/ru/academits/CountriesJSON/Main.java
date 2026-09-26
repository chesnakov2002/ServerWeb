package ru.academits.CountriesJSON;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            List<Countries> countries = mapper.readValue(new File("src/main/resources/countries.json"), new TypeReference<List<Countries>>() {
            });

            int sumPopulation = 0;

            for (Countries country : countries) {
                sumPopulation += country.population;
            }

            System.out.println("Суммарная численность стран = " + sumPopulation);

            List<Countries.Currency> uniqueCurrencies = new ArrayList<>();

            for (Countries country : countries) {
                if (country.currencies != null) {
                    for (Countries.Currency currency : country.currencies) {
                        if (!uniqueCurrencies.contains(currency)) {
                            uniqueCurrencies.add(currency);
                        }
                    }
                }
            }

            System.out.println("Перечень всех валют:" + uniqueCurrencies);

            List<Countries> largeCountries = new ArrayList<>();

            for (Countries country : countries) {
                if (country.population >= 1000000) {
                    largeCountries.add(country);
                }
            }

            mapper.writeValue(new File("result.json"), largeCountries);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при работе программы", e);
        }
    }
}
