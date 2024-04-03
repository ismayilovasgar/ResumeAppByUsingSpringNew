package com.company.service.inter;

import com.company.entity.Country;

import java.util.List;

public interface CountryServiceInter {
    public List<Country> getAllCountry();

    public boolean removeCountry(int id);

    public boolean updateCountry(Country country);
}
