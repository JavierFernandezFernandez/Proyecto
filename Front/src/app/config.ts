import { HttpHeaders } from "@angular/common/http";

export const API_URL = 'http://localhost:8080';
export const API_KET = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGdvQGdtYWlsLmNvbSIsImV4cCI6MTY4NDYwNjI5Mywibm9tYnJlIjoiSnVhbiJ9.Qgkz4ex8P6thj44G3gZroZ8whxyTg4nx06kkHiQIr_M';
export const BRANDS: string[] = ['Intel', 'AMD', 'Nvidia', 'Windows'];

export function GET_HEADERS(): HttpHeaders {
  let headers:HttpHeaders = new HttpHeaders();
  const token = localStorage.getItem('token');
  if (token) {
    return headers.set('Authorization', `Bearer ${token}`);
  }
  return headers
}

