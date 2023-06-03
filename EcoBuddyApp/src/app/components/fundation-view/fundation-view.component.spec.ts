import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FundationViewComponent } from './fundation-view.component';

describe('FundationViewComponent', () => {
  let component: FundationViewComponent;
  let fixture: ComponentFixture<FundationViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FundationViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FundationViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
