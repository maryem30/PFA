import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from 'app/shared/User';
import {NgForm } from '@angular/forms'

@Injectable({
  providedIn: 'root'
})
export class AdministratorService {

  constructor(private http: HttpClient) { }
  getAll(): Observable<any> {
    return this.http.get('http://localhost:9099/administrators/all');
  }
  deleteAdmin(id: String) {
    return this.http.delete('http://localhost:9099/administrators/'+id)
  }
  addAdmin(administrator: User): Observable<any> {
    return this.http.post('http://localhost:9099/administrators/',administrator);
  }

  getAdmin(page: number) {
    return this.http.get('http://localhost:9099/administrators/page?page='+page);

  }
}
