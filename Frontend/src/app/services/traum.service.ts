import { Injectable } from '@angular/core';
import { Traum } from '../models/traum';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/enironment';

@Injectable({
  providedIn: 'root'
})
export class TraumService {
  private baseUrl = environment.apiBackendUrl;

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Traum[]> {
    return this.http.get<Traum[]>(`${this.baseUrl}/dreams`);
  }

  add(traum: FormData): Observable<Traum> {
    return this.http.post<Traum>(`${this.baseUrl}/dreams`, traum);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/dreams/${id}`);
  }
}
