package com.santander.helloWord.model;

public class HelloWord {

    private String message;
    private String dateTime;


    public HelloWord(String message, String dateTime) {
        this.message = message;
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }


}
