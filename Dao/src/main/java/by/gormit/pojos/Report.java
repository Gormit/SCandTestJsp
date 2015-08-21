package by.gormit.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Gormit on 21.08.2015.
 * Entity - Report.
 * Bean class for working with entity-Report
 */

@Entity
public class Report implements Serializable {

    private static final long serialVersionUID = -750928108152897654L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private String performer;

    @Column(nullable = false)
    private String activity;

    public Report() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        if (id != report.id) return false;
        if (!startDate.equals(report.startDate)) return false;
        if (!endDate.equals(report.endDate)) return false;
        if (!performer.equals(report.performer)) return false;
        return activity.equals(report.activity);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + performer.hashCode();
        result = 31 * result + activity.hashCode();
        return result;
    }
}
