import { TestBed } from '@angular/core/testing';

import { InternshipinvalidService } from './internshipinvalid.service';

describe('InternshipinvalidService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: InternshipinvalidService = TestBed.get(InternshipinvalidService);
    expect(service).toBeTruthy();
  });
});
