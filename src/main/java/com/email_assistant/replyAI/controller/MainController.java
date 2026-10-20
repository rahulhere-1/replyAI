package com.email_assistant.replyAI.controller;

import com.email_assistant.replyAI.dto.EmailContent;
import com.email_assistant.replyAI.dto.ResponseBody;
import com.email_assistant.replyAI.service.ReplyService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {



    private final ReplyService replyService;

    public MainController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @PostMapping("/reply")
    public ResponseEntity<ResponseBody> writeResponse(@RequestBody EmailContent emailContent){
        String response = replyService.writeResponse(emailContent);
        return ResponseEntity.ok().body(new ResponseBody(response));
    }
}
