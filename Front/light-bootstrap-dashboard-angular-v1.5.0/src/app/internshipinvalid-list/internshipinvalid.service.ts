import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
@Injectable({
  providedIn: 'root'
})
export class InternshipinvalidService {

  constructor(private http: HttpClient) { }
  getAllInvalide(): Observable<any> {
    return this.http.get('http://localhost:9099/internshipinvalid/all');
}
deleteStage(id: string) {
  return this.http.delete('http://localhost:9099/internship/' + id)
}
getById(id: String) {
  return this.http.get('http://localhost:9099/internship/' + id)
}

}
