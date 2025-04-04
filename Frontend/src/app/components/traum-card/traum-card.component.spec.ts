import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TraumCardComponent } from './traum-card.component';

describe('TraumCardComponent', () => {
  let component: TraumCardComponent;
  let fixture: ComponentFixture<TraumCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TraumCardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TraumCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
