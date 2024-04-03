
package com.company.dao.inter;

import com.company.entity.EmploymentHistory;
import java.util.List;

/**
 *
 * @author asgar
 */
public interface EmploymentHistoryDaoInter {

    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);

}
