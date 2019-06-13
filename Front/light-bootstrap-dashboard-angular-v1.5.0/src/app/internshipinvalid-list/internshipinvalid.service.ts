import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class InternshipinvalidService {

  constructor(private http: HttpClient) { }

  getAll(){
    return this.http.get("http://localhost:9099/internshipinvalid/all");
  }

  deleteStag(id: string) {
    return this.http.delete('http://localhost:9099/internshipinvalid/'+id)
  }
  getById(id: String):Observable<any>{
      return this.http.get('http://localhost:9099/internshipinvalid/'+id);
    }
  
}


