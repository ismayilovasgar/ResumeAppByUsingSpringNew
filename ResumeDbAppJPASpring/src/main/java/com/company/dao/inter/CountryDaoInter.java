/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.Country;
import java.util.List;

/**
 *
 * @author asgar
 */
public interface CountryDaoInter {

    public List<Country> getAllCountry();

    public boolean removeCountry(int id);

    public boolean updateCountry(Country c);
}
