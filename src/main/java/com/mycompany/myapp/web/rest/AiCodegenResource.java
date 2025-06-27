package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.ai.AiCodegenService;
import com.mycompany.myapp.ai.AiCodegenService.AiGenerationResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class AiCodegenResource {

    private final AiCodegenService aiCodegenService;

    public AiCodegenResource(AiCodegenService aiCodegenService) {
        this.aiCodegenService = aiCodegenService;
    }

    @PostMapping("/codegen")
    public ResponseEntity<AiGenerationResult> generateAngularCode(@RequestBody Map<String, String> request) {
        String prompt = request.get("prompt");
        AiGenerationResult result = aiCodegenService.generateAngularComponent(prompt);
        return ResponseEntity.ok(result);
    }
}
