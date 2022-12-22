package com.example.switterv1.domain;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Message() {
    }

    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    private String text;
    private String tag;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }
}
