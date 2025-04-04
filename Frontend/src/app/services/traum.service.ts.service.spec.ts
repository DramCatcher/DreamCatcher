import { TestBed } from '@angular/core/testing';

import { TraumServiceTsService } from './traum.service.ts.service';

describe('TraumServiceTsService', () => {
  let service: TraumServiceTsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TraumServiceTsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
