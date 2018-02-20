import { Component, OnInit } from '@angular/core';
import { DismissalNotice } from "../dismissal-notice";
import { DismissalNoticeService } from "../dismissal-notice.service";

@Component({
  selector: 'app-dismissal-notice',
  templateUrl: './dismissal-notice.component.html',
  styleUrls: ['./dismissal-notice.component.css']
})
export class DismissalNoticeComponent implements OnInit {
  dismissalNotice: DismissalNotice

  constructor(private dismissalNoticeService: DismissalNoticeService) {
    this.dismissalNotice = new DismissalNotice;
  }

  ngOnInit() {
  }

  generate(): void {
    this.dismissalNoticeService.generate(this.dismissalNotice).subscribe();
  }

}
