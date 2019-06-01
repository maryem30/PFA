import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class StagiaireService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get('http://localhost:9099/stagiaires/all');
  }
  deleteStag(id: string) {
    return this.http.delete('http://localhost:9099/stagiaires/'+id)
  }
}


