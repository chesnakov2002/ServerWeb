package ru.academits.countries_json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            List<County> countries = mapper.readValue(new File("src/main/resources/countries.json"), new TypeReference<List<County>>() {
            });

            int sumPopulation = 0;

            for (County country : countries) {
                sumPopulation += country.getPopulation();
            }

            System.out.println("Суммарная численность стран = " + sumPopulation);

            List<Currency> uniqueCurrencies = new ArrayList<>();

            for (County country : countries) {
                if (country.getCurrencies() != null) {
                    for (Currency currency : country.getCurrencies()) {
                        if (!uniqueCurrencies.contains(currency)) {
                            uniqueCurrencies.add(currency);
                        }
                    }
                }
            }

            System.out.println("Перечень всех валют:" + uniqueCurrencies);

            List<County> largeCountries = new ArrayList<>();

            for (County country : countries) {
                if (country.getPopulation() >= 1000000) {
                    largeCountries.add(country);
                }
            }

            mapper.writeValue(new File("result.json"), largeCountries);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при работе программы", e);
        }
    }
}
