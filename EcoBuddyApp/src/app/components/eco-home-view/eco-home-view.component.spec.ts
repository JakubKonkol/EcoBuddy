import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EcoHomeViewComponent } from './eco-home-view.component';

describe('EcoHomeViewComponent', () => {
  let component: EcoHomeViewComponent;
  let fixture: ComponentFixture<EcoHomeViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EcoHomeViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EcoHomeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
