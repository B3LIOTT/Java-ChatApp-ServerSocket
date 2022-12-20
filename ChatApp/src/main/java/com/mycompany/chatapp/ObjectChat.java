package com.mycompany.chatapp;

import java.io.Serializable;

public class ObjectChat implements Serializable {
    private String time;
    private String message;
    private String envoyeur;
    private String channel;

    public ObjectChat(String time, String message, String envoyeur) {
        this.time = time;
        this.message = message;
        this.envoyeur = envoyeur;
    }

    public String getTime() {
        return time;
    }

    public String getEnvoyeur() {
        return envoyeur;
    }

    public String getMessage() {
        return message;
    }
    public String getChannel() {
        return channel;
    }
}
