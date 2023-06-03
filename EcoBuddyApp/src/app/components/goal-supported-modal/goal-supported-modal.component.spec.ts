import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GoalSupportedModalComponent } from './goal-supported-modal.component';

describe('GoalSupportedModalComponent', () => {
  let component: GoalSupportedModalComponent;
  let fixture: ComponentFixture<GoalSupportedModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GoalSupportedModalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GoalSupportedModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
