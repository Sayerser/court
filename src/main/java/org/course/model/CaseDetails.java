package org.course.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class CaseDetails {

    private Integer id;
    private String caseStatus;
    private String lawyerName;
    private String lawyerSurname;
    private Date filingDate;
    private Date closingDate;

    // Конструктор
    public CaseDetails(Integer id, String caseStatus, String lawyerName, String lawyerSurname, Date filingDate, Date closingDate) {
        this.id = id;
        this.caseStatus = caseStatus;
        this.lawyerName = lawyerName;
        this.lawyerSurname = lawyerSurname;
        this.filingDate = filingDate;
        this.closingDate = closingDate;
    }
}
