package com.kh.finalPrjPm.dto;

public class ChatMessageDto {
    public enum MessageType {
        ENTER, TALK
    }
    private MessageType type;
    private String roomId;
    private String sender;
    private String message;
}
