import { Component, OnInit } from '@angular/core';
import { InternshipinvalidService } from './Internshipinvalid.service';
import { InternshipService } from '../internship-list/Internship.service';
import { FormGroup } from '@angular/forms';


@Component({
  selector: 'app-internshipinvalid-list',
  templateUrl: './internshipinvalid-list.component.html',
  styleUrls: ['./internshipinvalid-list.component.scss']
})
export class InternshipinvalidListComponent implements OnInit {

  public tabInternshipinvalid: Array <any>;
  
  public user;
  public intership = new FormData;


  constructor(private internshipService: InternshipService, private  internshipinvalidService: InternshipinvalidService) { }

  ngOnInit() {
    this.affiche();
  }

  affiche() {
    this.internshipinvalidService.getAll().subscribe((data:Array<any>) => {
        this.tabInternshipinvalid = data;

});
}

deleteInternship(id){
  this.internshipinvalidService.deleteStag(id).subscribe((response => {console.log(response); this.internshipinvalidService.getAll().subscribe((data:Array<any>)=>{this.tabInternshipinvalid = data;})

  }));
}

valider(id){
 
  this.internshipinvalidService.getById(id).subscribe((data:Array<FormGroup>) => {
  this.deleteInternship(id)
  this.internshipService.add(data).subscribe();
   console.log(data);
});
  
  
}

}
