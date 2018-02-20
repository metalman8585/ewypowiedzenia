import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DismissalNoticeComponent } from './dismissal-notice.component';

describe('DismissalNoticeComponent', () => {
  let component: DismissalNoticeComponent;
  let fixture: ComponentFixture<DismissalNoticeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DismissalNoticeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DismissalNoticeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
