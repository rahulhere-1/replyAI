package com.email_assistant.replyAI.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIModelConfig {

        @Bean
        public ChatClient gemmaChatClient(ChatClient.Builder builder){
            return builder.build();
        }

}
