import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BearComponent } from './bear/bear.component';

@NgModule({
  declarations: [
    AppComponent,
    BearComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent, BearComponent]
})
export class AppModule { }
