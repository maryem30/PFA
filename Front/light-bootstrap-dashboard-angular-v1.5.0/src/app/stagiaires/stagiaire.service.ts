import { Injectable } from '@angular/core';
import {NgForm } from '@angular/forms'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from 'app/shared/User';

@Injectable()
export class StagiaireService {
  user : User;

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get('http://localhost:9099/stagiaires/all');
  }
  getById(id: String){
    return this.http.get('http://localhost:9099/stagiaires/'+id);
  }
  deleteStag(id: string) {
    return this.http.delete('http://localhost:9099/stagiaires/'+id)
  }
  add(stagiaire: User): Observable<any> {
    return this.http.post('http://localhost:9099/stagiaires/',stagiaire);
  }

  getSatgiaire(page:number){
    return this.http.get('http://localhost:9099/stagiaires/page?page='+page);
  }
}


