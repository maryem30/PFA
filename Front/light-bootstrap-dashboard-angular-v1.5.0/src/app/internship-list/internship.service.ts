import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
@Injectable({
  providedIn: 'root'
})
export class InternshipService {

  constructor(private http: HttpClient) { }
  getAll(): Observable<any> {
    return this.http.get('http://localhost:9099/internship/all');
  }
}
