package com.company.dao.impl;

import com.company.entity.EmploymentHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author asgar
 */
@Repository
public interface EmploymentHistoryRepositoryCustom {

    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);

}
