import { Injectable } from '@angular/core';
import { Observable } from '../../../node_modules/rxjs';
import { HttpClient } from '../../../node_modules/@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TeamService {
  constructor(private http: HttpClient) { }
  getAll(): Observable<any> {
    return this.http.get('http://localhost:9099/team/all');
  }
  deleteStage(id: string) {
    return this.http.delete('http://localhost:9099/team/' + id)
  }
  getTeam(page: number) {
    return this.http.get('http://localhost:9099/team/page?page=' + page);
  }
}
