import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule }    from '@angular/common/http';
import { MatFormFieldModule, MatInputModule, MatDatepickerModule, MatNativeDateModule, MatButtonModule } from '@angular/material';

import { AppComponent } from './app.component';
import { DismissalNoticeComponent } from './dismissal-notice/dismissal-notice.component';
import { DismissalNoticeService } from "./dismissal-notice.service";


@NgModule({
  declarations: [
    AppComponent,
    DismissalNoticeComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatButtonModule,
    HttpClientModule
  ],
  providers: [DismissalNoticeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
