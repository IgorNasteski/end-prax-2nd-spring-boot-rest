package rest.example.rest.model;

import javax.persistence.*;

@Entity
@Table(name = "log_event")
public class LogEvent {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String description;
    private String category;
    private String status;
    @Column(name = "date_time")
    private String dateTime;

    //constructor
    public LogEvent() {
    }

    //BUILDER PATTERN
    public static class LogEventBuilder{
        //fields
        private int id;
        private String description;
        private String category;
        private String status;
        private String dateTime;

        //constructor
        public LogEventBuilder(){}
        public static LogEventBuilder anLogEvent(){
            return new LogEventBuilder();
        }

        //with
        public LogEventBuilder withId(int id){
            this.id = id;
            return this;
        }
        public LogEventBuilder withDescription(String description){
            this.description = description;
            return this;
        }
        public LogEventBuilder withCategory(String category){
            this.category = category;
            return this;
        }
        public LogEventBuilder withStatus(String status){
            this.status = status;
            return this;
        }
        public LogEventBuilder withDateTime(String dateTime){
            this.dateTime = dateTime;
            return this;
        }

        //constructor "build" of main class LogEvent
        public LogEvent build(){
            LogEvent logEvent = new LogEvent();
                logEvent.id = this.id;
                logEvent.description = this.description;
                logEvent.category = this.category;
                logEvent.status = this.status;
                logEvent.dateTime = this.dateTime;
            return logEvent;
        }
    }

    //hashcode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEvent logEvent = (LogEvent) o;

        if (id != logEvent.id) return false;
        if (description != null ? !description.equals(logEvent.description) : logEvent.description != null)
            return false;
        if (category != null ? !category.equals(logEvent.category) : logEvent.category != null) return false;
        if (status != null ? !status.equals(logEvent.status) : logEvent.status != null) return false;
        return dateTime != null ? dateTime.equals(logEvent.dateTime) : logEvent.dateTime == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }

    //getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
//id, description(user has added new participant npr),
//category(add new - posto se radi o dodavanju novog), status(failed ili successful), dateTime(da se upise
//vreme kad se to dodavanje desilo)