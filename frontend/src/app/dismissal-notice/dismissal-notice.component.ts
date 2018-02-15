import { Component, OnInit } from '@angular/core';
import { DismissalNotice } from "./dismissal-notice";

@Component({
  selector: 'app-dismissal-notice',
  templateUrl: './dismissal-notice.component.html',
  styleUrls: ['./dismissal-notice.component.css']
})
export class DismissalNoticeComponent implements OnInit {
  dismissalNotice: DismissalNotice;

  constructor() { }

  ngOnInit() {
  }

}
