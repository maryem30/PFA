import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from 'app/shared/User';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class StagiaireService {
  user : User[];
  private data = new BehaviorSubject(this.user);
  currentMessage = this.data.asObservable();
  private click = new BehaviorSubject('add');
  bool = this.click.asObservable();

  constructor(private http: HttpClient) {
  }

  changeMessage(data: User[]) {
    this.data.next(data)
  }

  changeClick(b: string) {
    this.click.next(b)
  }

  getAll(): Observable<any> {
    return this.http.get('http://localhost:9099/stagiaires/all');
  }
  getById(id: String):Observable<any>{
    return this.http.get('http://localhost:9099/stagiaires/'+id);
  }
  deleteStag(id: string) {
    return this.http.delete('http://localhost:9099/stagiaires/'+id)
  }
  add(stagiaire: User): Observable<any> {
    return this.http.post('http://localhost:9099/stagiaires/',stagiaire);
  }

  getSatgiaire(page:number): Observable<any>{
    return this.http.get('http://localhost:9099/stagiaires/page?page='+page);
  }
  updateSatgiaire(stagiaire: User){
    return this.http.put('http://localhost:9099/stagiaires/',stagiaire);
  }
}


