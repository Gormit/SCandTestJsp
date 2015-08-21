package by.gormit.controller;

import by.gormit.pojos.Report;
import by.gormit.service.ReportService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Gormit on 21.08.2015.
 */

@Controller
public class ReportController {

    private static Logger log = Logger.getLogger(ReportController.class);

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/reportsRequest", method = RequestMethod.GET)
    public String reportsRequest(ModelMap map) {
        List<String> performersList = reportService.getPerformersList();
        map.put("performersList", performersList);
        return "reportsRequest";
    }

    @RequestMapping(value = "/reports", method = RequestMethod.GET)
    public String reportsList(@RequestParam String startDate,
                              @RequestParam String endDate,
                              @RequestParam String performer,
                              @RequestParam String timePeriod,
                              ModelMap map) {

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = null;
            Date date2 = null;

        if (("").equals(timePeriod)) {
            try {
                date1 = format.parse(startDate);
                date2 = format.parse(endDate);
            } catch (ParseException e) {
                log.error("Parse Exception" + e);
            }
        } else {
            Date curentDate = new Date();
            switch (timePeriod){
                case "lastQtr":
                    date1 = new Date();
                    break;
                case "lastMonth":
                    date1 = new Date();
                    break;
                case "lastCalendarYear":
                    date1 = new Date(curentDate.getYear() - 1,0,1);
                    date2 = new Date(curentDate.getYear() - 1,11,31);
                    break;
                case "currentYearToDate":
                    date1 = new Date();
                    break;
                case "currentQtrToDate":
                    date1 = new Date();
                    break;
                case "currentMonthToDate":
                    date1 = new Date();
                    break;
            }
        }


        List<Report> reportList = reportService.getReportsList(date1, date2, performer);
        map.put("sDate", date1);
        map.put("eDate", date2);
        map.put("reportList", reportList);
        return "reports";
    }

}
