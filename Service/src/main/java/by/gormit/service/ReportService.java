package by.gormit.service;

import by.gormit.pojos.Report;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by Gormit on 21.08.2015.
 */

public interface ReportService {

    Report add(Report report);
    void update(Report report);
    Report get(Serializable id);
    void delete(Report report);
    void saveOrUpdate(Report report);
    List<String> getPerformersList();
    List<Report> getReportsList(Date startDate, Date endDate, String performer);
}
