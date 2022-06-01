import { TestBed } from '@angular/core/testing';

import { MMServiceService } from './mmservice.service';

describe('MMServiceService', () => {
  let service: MMServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MMServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
