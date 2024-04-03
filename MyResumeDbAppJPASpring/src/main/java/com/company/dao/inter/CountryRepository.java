package com.company.dao.inter;

import com.company.dao.impl.CountryRepositoryCustom;
import com.company.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>, CountryRepositoryCustom {
}
