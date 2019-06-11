import { Subscription } from 'rxjs/Subscription';
import { InternshipinvalidService } from './internshipinvalid.service';
import { InternshipService } from './../internship-list/internship.service';

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-internshipinvalid-list',
  templateUrl: './internshipinvalid-list.component.html',
  styleUrls: ['./internshipinvalid-list.component.scss']
})
export class InternshipinvalidListComponent implements OnInit {
  public tabStagesInvalide: Array <any>;
  public tabStage: Array <any>;
  stage: Array<any>;
  constructor(private internshipinvalidservice: InternshipinvalidService , private internshipvalidservice: InternshipService) { }

  ngOnInit() {
    this.affiche();
  }
affiche() {
  this.internshipinvalidservice.getAllInvalide().subscribe(data => {
      this.tabStagesInvalide = data;

})
};
deleteStage(id) {
  // tslint:disable-next-line:max-line-length
  this.internshipinvalidservice.deleteStage(id).subscribe((response => {console.log(response); this.internshipinvalidservice.getAllInvalide().subscribe(data => {
    this.tabStagesInvalide = data; })

  }));
}
valider(id: String) {
  this.internshipinvalidservice.getById(id).subscribe( (data: Array<any>) => {
    this.tabStage = data;
    this.deleteStage(id);
    console.log(this.tabStage);
  });
}
}
