import { TestBed } from '@angular/core/testing';

import { LineasFacturaService } from './linea-factura.service';

describe('LineasFacturaService', () => {
  let service: LineasFacturaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LineasFacturaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
