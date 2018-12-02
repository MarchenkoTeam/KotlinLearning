import { TestBed } from '@angular/core/testing';

import { ApiHostInterceptorService } from './api-host-interceptor.service';

describe('ApiHostInterceptorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ApiHostInterceptorService = TestBed.get(ApiHostInterceptorService);
    expect(service).toBeTruthy();
  });
});
