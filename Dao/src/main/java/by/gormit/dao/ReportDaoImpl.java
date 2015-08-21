package by.gormit.dao;

import by.gormit.pojos.Report;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by Gormit on 21.08.2015.
 */

@Repository
public class ReportDaoImpl implements ReportDao {

    private static Logger log = Logger.getLogger(ReportDaoImpl.class);
    private SessionFactory sessionFactory;

    @Autowired
    public ReportDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Report add(Report report) {
        return (Report) getSession().save(report);
    }

    @Override
    public void update(Report report) {
        getSession().update(report);
    }

    @Override
    public Report get(Serializable id) {
        return (Report) getSession().get(Report.class, id);
    }

    @Override
    public void delete(Report report) {
        getSession().delete(report);
    }

    @Override
    public void saveOrUpdate(Report report) {
        getSession().saveOrUpdate(report);
    }

    @Override
    public List<String> getPerformersList() {
        Criteria criteria = getSession().createCriteria(Report.class);
        criteria.addOrder(Order.asc("performer"));
        return criteria.list();
    }

    @Override
    public List<Report> getReportsList(Date startDate, Date endDate, String performer) {
        Criteria criteria = getSession().createCriteria(Report.class);
        criteria.add(Restrictions.ge("startDate", startDate));
        criteria.add(Restrictions.le("endDate", endDate));
        if (!performer.equals("all")) {
            criteria.add(Restrictions.like("performer", performer));
        }
        return criteria.list();
    }

}
