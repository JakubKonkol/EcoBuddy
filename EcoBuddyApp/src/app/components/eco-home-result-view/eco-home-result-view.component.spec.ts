import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EcoHomeResultViewComponent } from './eco-home-result-view.component';

describe('EcoHomeResultViewComponent', () => {
  let component: EcoHomeResultViewComponent;
  let fixture: ComponentFixture<EcoHomeResultViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EcoHomeResultViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EcoHomeResultViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
