package com.email_assistant.replyAI.service;

import com.email_assistant.replyAI.dto.EmailContent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    private final ChatClient chatClient;

    @Value("classpath:/promptTemplates/systemTemplate.st")
    private Resource systemTemplate;

    public ReplyService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String writeResponse(EmailContent emailContent){
        return chatClient.prompt().system(systemTemplate).user(emailContent.content()).call().content();
    }

}
