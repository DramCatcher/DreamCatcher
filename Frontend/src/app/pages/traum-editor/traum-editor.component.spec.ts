import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TraumEditorComponent } from './traum-editor.component';

describe('TraumEditorComponent', () => {
  let component: TraumEditorComponent;
  let fixture: ComponentFixture<TraumEditorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TraumEditorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TraumEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
