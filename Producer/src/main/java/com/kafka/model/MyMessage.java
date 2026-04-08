package com.kafka.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MyMessage {

    private int id;
    private String title;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm")
    private Date publishingDate;

    @Override
    public String toString() {
        return "MyMessage{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishingDate=" + publishingDate +
                '}';
    }
}
