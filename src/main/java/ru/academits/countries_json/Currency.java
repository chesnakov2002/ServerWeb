package ru.academits.countries_json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

public class Currency {

    @JsonIgnoreProperties(ignoreUnknown = true)
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
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Currency currency = (Currency) o;
        return Objects.equals(code, currency.code) && Objects.equals(name, currency.name) && Objects.equals(symbol, currency.symbol);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Objects.hashCode(code);
        hash = prime * hash + Objects.hashCode(name);
        hash = prime * hash + Objects.hashCode(symbol);
        return hash;
    }
}

