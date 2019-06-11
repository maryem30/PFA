import { Component, OnInit } from '@angular/core';
import { AdministratorService } from './administrator-list.service';
import { User } from './../shared/User';

@Component({
  selector: 'app-administrator-list',
  templateUrl: './administrator-list.component.html',
  styleUrls: ['./administrator-list.component.scss']
})
export class AdministratorListComponent implements OnInit {
  AdministratorService: any;

  public tabAdmin: Array <any>;
  administrators: Array<any>;
  public user : User;
  public nom : String;
  private page: number = 0;
  private pages: Array<any>;
  private i:number;
  public prenom: String;
  public id : String;
  public email : String;
  public tel : String;
  constructor(private administratorService: AdministratorService) {}

  ngOnInit() {
    this.getAdminPage();
  };
  setPage(i,event:any){
    this.i=i;
    event.preventDefault();
    this.page=i;
    this.getAdminPage();
  }
affiche() {
  this.administratorService.getAll().subscribe(data => {
      this.tabAdmin = data;

});
}
getAdminPage(){
  this.administratorService.getAdmin(this.page).subscribe(data =>{
    this.tabAdmin = data['content'];
    this.pages= new Array(data['totalPages']);
  });
}
deleteAdmin(id,i,event:any) {
  this.administratorService.deleteAdmin(id).subscribe(
    (response => {console.log(response); this.administratorService.getAll().subscribe(data => {this.tabAdmin = data; })

   }))
   this.setPage(i,event);
}

}
