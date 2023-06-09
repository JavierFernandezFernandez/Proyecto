import { TestBed } from '@angular/core/testing';

import { LineasPedidoService } from './linea-pedido.service';

describe('LineasPedidoService', () => {
  let service: LineasPedidoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LineasPedidoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
