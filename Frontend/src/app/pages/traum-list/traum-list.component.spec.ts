import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TraumListComponent } from './traum-list.component';

describe('TraumListComponent', () => {
  let component: TraumListComponent;
  let fixture: ComponentFixture<TraumListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TraumListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TraumListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
