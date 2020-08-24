package rest.example.rest.exception;

//SIMPLE POJO CLASS
public class ModelErrorResponse {

                //FIELDS
    private int status;
    private String message;
    private long timeStamp;

                //CONSTRUCTORS
    public ModelErrorResponse(){
    }

    public ModelErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

                //GETTERS AND SETTERS
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public long getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
