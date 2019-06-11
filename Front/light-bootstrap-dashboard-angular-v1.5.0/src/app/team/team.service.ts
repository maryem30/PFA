import { Injectable } from '@angular/core';
import {NgForm } from '@angular/forms'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from 'app/shared/User';

@Injectable()
export class TeamService {
  user: User;

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get('http://localhost:9099/team/all');
  }
  deleteTeam(id: string) {
    return this.http.delete('http://localhost:9099/team/'+id)
  }
  add(team: User): Observable<any> {
    return this.http.post('http://localhost:9099/team/',team);
  }

  getTeam(page:number){
    return this.http.get('http://localhost:9099/team/page?page='+page);
  }
}


