import { Injectable } from '@angular/core';
import { Traum } from '../models/traum';

@Injectable({
  providedIn: 'root'
})
export class TraumService {
  private key = 'traeume';

  getAll(): Traum[] {
    const raw = localStorage.getItem(this.key);
    return raw ? JSON.parse(raw) : [];
  }

  add(traum: Traum) {
    const all = this.getAll();
    all.push(traum);
    localStorage.setItem(this.key, JSON.stringify(all));
  }

  delete(index: number) {
    const all = this.getAll();
    all.splice(index, 1);
    localStorage.setItem(this.key, JSON.stringify(all));
  }

}
