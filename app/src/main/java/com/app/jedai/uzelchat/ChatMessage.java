package com.app.jedai.uzelchat;

/**
 * Created by jedai on 20.06.16.
 */
public class ChatMessage {

    String name;
    String message;

    public ChatMessage() {
    }

    public ChatMessage(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
