import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InternshipinvalidListComponent } from './internshipinvalid-list.component';

describe('InternshipinvalidListComponent', () => {
  let component: InternshipinvalidListComponent;
  let fixture: ComponentFixture<InternshipinvalidListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InternshipinvalidListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InternshipinvalidListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
