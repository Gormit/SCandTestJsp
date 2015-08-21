package by.gormit.service;



import by.gormit.dao.ReportDao;
import by.gormit.pojos.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by Gormit on 21.08.2015.
 */

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDao reportDao;

    public ReportServiceImpl() {
    }

    @Override
    public Report add(Report report) {
        return reportDao.add(report);
    }

    @Override
    public void update(Report report) {
        reportDao.update(report);
    }

    @Override
    public Report get(Serializable id) {
        return reportDao.get(id);
    }

    @Override
    public void delete(Report report) {
        reportDao.delete(report);
    }

    @Override
    public void saveOrUpdate(Report report) {
        reportDao.saveOrUpdate(report);
    }

    @Override
    public List<String> getPerformersList() {
        return reportDao.getPerformersList();
    }

    @Override
    public List<Report> getReportsList(Date startDate, Date endDate, String performer) {
        return reportDao.getReportsList(startDate, endDate, performer);
    }

}
