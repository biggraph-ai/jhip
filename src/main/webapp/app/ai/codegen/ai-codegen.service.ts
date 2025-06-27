import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface GeneratedCode {
  tsCode: string;
  htmlCode: string;
}

@Injectable({ providedIn: 'root' })
export class AiCodegenService {
  constructor(private http: HttpClient) {}

  generate(prompt: string): Observable<GeneratedCode> {
    return this.http.post<GeneratedCode>('/api/ai/codegen', { prompt });
  }

  save(component: any) {
    return this.http.post('/api/generated-components', component);
  }
}
