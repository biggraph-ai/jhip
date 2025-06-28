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
    return this.http.post<GeneratedCode>('http://localhost:8080/api/ai/codegen', { prompt });
  }

  save(component: any) {
    return this.http.post('http://localhost:8080/api/generated-components', component);
  }
}
