import { Component } from '@angular/core';
import { AiCodegenService } from './ai-codegen.service';

@Component({
  selector: 'app-ai-codegen',
  templateUrl: './ai-codegen.component.html'
})
export class AiCodegenComponent {
  prompt = '';
  tsCode = '';
  htmlCode = '';

  constructor(private service: AiCodegenService) {}

  generate() {
    this.service.generate(this.prompt).subscribe(res => {
      this.tsCode = res.tsCode;
      this.htmlCode = res.htmlCode;
    });
  }

  save() {
    const body = { prompt: this.prompt, tsCode: this.tsCode, htmlCode: this.htmlCode };
    this.service.save(body).subscribe();
  }
}
