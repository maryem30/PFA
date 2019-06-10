import { Component, OnInit } from '@angular/core';
import { AdministratorService } from './administrator-list.service';

@Component({
  selector: 'app-administrator-list',
  templateUrl: './administrator-list.component.html',
  styleUrls: ['./administrator-list.component.scss']
})
export class AdministratorListComponent implements OnInit {

  public tabAdmin: Array <any>;
  administrators: Array<any>;
  constructor(private internshipservice: AdministratorService) {}

  ngOnInit() {
    this.affiche();
  };
affiche() {
  this.internshipservice.getAll().subscribe(data => {
      this.tabAdmin = data;

});
}

}
