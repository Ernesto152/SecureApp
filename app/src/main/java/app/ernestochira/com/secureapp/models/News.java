package app.ernestochira.com.secureapp.models;

/**
 * Created by usuario on 28/03/2017.
 */

public class News {
    private String user;
    private String typeIncidence;
    private String description;
    private String date;
    private String hour;
    private String evidence;

    public News(String user, String typeIncidence, String description, String date, String hour, String evidence) {
        this.user = user;
        this.typeIncidence = typeIncidence;
        this.description = description;
        this.date = date;
        this.hour = hour;
        this.evidence = evidence;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTypeIncidence() {
        return typeIncidence;
    }

    public void setTypeIncidence(String typeIncidence) {
        this.typeIncidence = typeIncidence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }
}
