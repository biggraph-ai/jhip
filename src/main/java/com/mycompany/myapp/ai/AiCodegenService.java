package com.mycompany.myapp.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AiCodegenService {

    @Value("${openai.api-key}")
    private String apiKey;

    public AiGenerationResult generateAngularComponent(String prompt) {
        // In a real implementation, call the OpenAI API here.
        String ts = "export class GeneratedComponent {}";
        String html = "<p>Generated component</p>";
        return new AiGenerationResult(ts, html);
    }

    public record AiGenerationResult(String tsCode, String htmlCode) {}
}
