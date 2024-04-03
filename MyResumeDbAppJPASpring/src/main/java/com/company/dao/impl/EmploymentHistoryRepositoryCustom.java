package com.company.dao.impl;

import com.company.entity.EmploymentHistory;

import java.util.List;

/**
 * @author asgar
 */
public interface EmploymentHistoryRepositoryCustom {

    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);

}
