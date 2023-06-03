import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MainBuddyViewComponent } from './main-buddy-view.component';

describe('MainBuddyViewComponent', () => {
  let component: MainBuddyViewComponent;
  let fixture: ComponentFixture<MainBuddyViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MainBuddyViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MainBuddyViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
