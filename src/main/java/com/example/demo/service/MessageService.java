package com.example.demo.service;

import com.example.demo.mapper.MessageMapper;
import com.example.demo.model.ChatForm;
import com.example.demo.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private final MessageMapper messageMapper;
    private List<String> chatMessages;

    public MessageService(MessageMapper messageMapper){
        this.messageMapper = messageMapper;
        this.chatMessages = new ArrayList<>();
    }

    public List<Message> getMessages() {
        return messageMapper.getAllMessage();
    }

    public int addMessage(ChatForm chatForm) {
        Message message = new Message();
        message.setUsername(chatForm.getUsername());
        switch(chatForm.getMessageType()){
            case "Say":
                message.setMessage(chatForm.getMessageText());
                break;
            case "Shout":
            case "Whisper":
                message.setMessage(chatForm.getMessageText().toUpperCase());
                break;
        }
        return messageMapper.insert(message);
    }


    //    public void addMessage(ChatForm chatForm) {
//        ChatMessage newMessage = new ChatMessage();
//        newMessage.setUsername(chatForm.getUsername());
//        switch(chatForm.getMessageType()){
//            case "Say":
//                newMessage.setMessage(chatForm.getMessageText());
//                break;
//            case "Shout":
//            case "Whisper":
//                newMessage.setMessage(chatForm.getMessageText().toUpperCase());
//                break;
//        }
//        this.chatMessages.add(newMessage);
//    }
}
