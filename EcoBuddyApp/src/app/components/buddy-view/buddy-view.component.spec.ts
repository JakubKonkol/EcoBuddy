import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuddyViewComponent } from './buddy-view.component';

describe('BuddyViewComponent', () => {
  let component: BuddyViewComponent;
  let fixture: ComponentFixture<BuddyViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuddyViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuddyViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
