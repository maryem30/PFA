import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
@Injectable({
  providedIn: 'root'
})
export class InternshipService {

  constructor(private http: HttpClient) { }
  getAllValid(): Observable<any> {
    return this.http.get('http://localhost:9099/internshipvalid/all');
  }
  add(intership) {
    return this.http.put('http://localhost:9099/internshipvalid/', intership);

  }

}
