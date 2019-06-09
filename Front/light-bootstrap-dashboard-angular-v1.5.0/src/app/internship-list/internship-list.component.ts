import { InternshipService } from './internship.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-internship-list',
  templateUrl: './internship-list.component.html',
  styleUrls: ['./internship-list.component.scss']
})
export class InternshipListComponent implements OnInit {
  public tabStage: Array <any>;
  stages: Array<any>;
  constructor(private internshipservice: InternshipService) {}

  ngOnInit() {
    this.affiche();
  };
affiche() {
  this.internshipservice.getAll().subscribe(data => {
      this.tabStage = data;

});
}

}
