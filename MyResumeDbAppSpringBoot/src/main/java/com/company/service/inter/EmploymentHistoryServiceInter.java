package com.company.service.inter;

import com.company.entity.EmploymentHistory;

import java.util.List;

public interface EmploymentHistoryServiceInter {
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);

}
