import { TestBed, inject } from '@angular/core/testing';

import { DismissalNoticeService } from './dismissal-notice.service';

describe('DismissalNoticeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DismissalNoticeService]
    });
  });

  it('should be created', inject([DismissalNoticeService], (service: DismissalNoticeService) => {
    expect(service).toBeTruthy();
  }));
});
