import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListekComponent } from './listek.component';

describe('ListekComponent', () => {
  let component: ListekComponent;
  let fixture: ComponentFixture<ListekComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListekComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListekComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
