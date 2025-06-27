import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AiCodegenComponent } from './ai/codegen/ai-codegen.component';
import { FormsModule } from '@angular/forms';

const routes: Routes = [
  { path: 'ai/codegen', component: AiCodegenComponent },
  { path: '', redirectTo: 'ai/codegen', pathMatch: 'full' }
];

@NgModule({
  declarations: [AppComponent, AiCodegenComponent],
  imports: [BrowserModule, HttpClientModule, FormsModule, RouterModule.forRoot(routes)],
  bootstrap: [AppComponent]
})
export class AppModule { }
