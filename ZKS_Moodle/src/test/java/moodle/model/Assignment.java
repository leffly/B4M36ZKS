package moodle.model;

public class Assignment {

    private String name;
    private int submissionDateDd;
    private int submissionDateMonth;
    private int submissionDateYear;
    private int submissionDateHh;
    private int submissionDateMm;
    private int dueDateDd;
    private int dueDateMonth;
    private int dueDateYear;
    private int dueDateHh;
    private int dueDateMm;

    public Assignment() {
    }

    public boolean createAssignment(String name, String submissionDateDd,
                      String submission_date_month, String submission_date_year,
                      String submission_date_hh, String submission_date_mm,
                      String due_date_dd, String due_date_month, String due_date_year,
                      String due_date_hh, String due_date_mm) {
        this.name = name;
        try {
            this.submissionDateDd = Integer.parseInt(submissionDateDd);
            this.submissionDateMonth = Integer.parseInt(submission_date_month);
            this.submissionDateYear = Integer.parseInt(submission_date_year);
            this.submissionDateHh = Integer.parseInt(submission_date_hh);
            this.submissionDateMm = Integer.parseInt(submission_date_mm);
            this.dueDateDd = Integer.parseInt(due_date_dd);
            this.dueDateMonth = Integer.parseInt(due_date_month);
            this.dueDateYear = Integer.parseInt(due_date_year);
            this.dueDateHh = Integer.parseInt(due_date_hh);
            this.dueDateMm = Integer.parseInt(due_date_mm);
        }catch (NumberFormatException ex){
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubmissionDateDd() {
        return submissionDateDd;
    }

    public void setSubmissionDateDd(int submissionDateDd) {
        this.submissionDateDd = submissionDateDd;
    }

    public int getSubmissionDateMonth() {
        return submissionDateMonth;
    }

    public void setSubmissionDateMonth(int submissionDateMonth) {
        this.submissionDateMonth = submissionDateMonth;
    }

    public int getSubmissionDateYear() {
        return submissionDateYear;
    }

    public void setSubmissionDateYear(int submissionDateYear) {
        this.submissionDateYear = submissionDateYear;
    }

    public int getSubmissionDateHh() {
        return submissionDateHh;
    }

    public void setSubmissionDateHh(int submissionDateHh) {
        this.submissionDateHh = submissionDateHh;
    }

    public int getSubmissionDateMm() {
        return submissionDateMm;
    }

    public void setSubmissionDateMm(int submissionDateMm) {
        this.submissionDateMm = submissionDateMm;
    }

    public int getDueDateDd() {
        return dueDateDd;
    }

    public void setDueDateDd(int dueDateDd) {
        this.dueDateDd = dueDateDd;
    }

    public int getDueDateMonth() {
        return dueDateMonth;
    }

    public void setDueDateMonth(int dueDateMonth) {
        this.dueDateMonth = dueDateMonth;
    }

    public int getDueDateYear() {
        return dueDateYear;
    }

    public void setDueDateYear(int dueDateYear) {
        this.dueDateYear = dueDateYear;
    }

    public int getDueDateHh() {
        return dueDateHh;
    }

    public void setDueDateHh(int dueDateHh) {
        this.dueDateHh = dueDateHh;
    }

    public int getDueDateMm() {
        return dueDateMm;
    }

    public void setDueDateMm(int dueDateMm) {
        this.dueDateMm = dueDateMm;
    }
}
