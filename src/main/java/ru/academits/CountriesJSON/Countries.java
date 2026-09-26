package ru.academits.CountriesJSON;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Countries {
    public String name;
    public int population;
    public List<Currency> currencies;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Currency{
        public String code;
        public String name;
        public String symbol;

        @Override
        public String toString() {
            return "{code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    ", symbol='" + symbol + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Currency currency = (Currency) o;
            return Objects.equals(code, currency.code) && Objects.equals(name, currency.name) && Objects.equals(symbol, currency.symbol);
        }

        @Override
        public int hashCode() {
            return Objects.hash(code, name, symbol);
        }
    }
}