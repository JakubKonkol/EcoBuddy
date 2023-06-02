import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SingleTaskViewComponent } from './single-task-view.component';

describe('SingleTaskViewComponent', () => {
  let component: SingleTaskViewComponent;
  let fixture: ComponentFixture<SingleTaskViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SingleTaskViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SingleTaskViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
