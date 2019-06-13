import { TeamService } from './team.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.scss']
})
export class TeamComponent implements OnInit {

  public tabStage: Array <any>;
  stages: Array<any>;
  public teamName: string;
  public contractTypeValid = "False";
  private page: number = 0;
  private pages: Array<any>;
  private i: number;
  constructor(private teamservice: TeamService) {}

  ngOnInit() {
    this.getTeamPage();
     }
  affiche() {
    this.teamservice.getAll().subscribe(data => {
        this.tabStage = data;
  })
  };
  getTeamPage() {
    this.teamservice.getTeam(this.page).subscribe(data => {
      this.tabStage = data['content'];
      this.pages = new Array(data['totalPages']);
    });
  }
  setPage(i, event : any){
    this.i = i;
    event.preventDefault();
    this.page = i;
    this.getTeamPage();
  }
  deleteStage(id, i, event: any) {
    // tslint:disable-next-line:max-line-length
    this.teamservice.deleteStage(id).subscribe((response => {console.log(response); this.teamservice.getAll().subscribe(data => {
      this.tabStage = data; })
    }));
    this.setPage( i, event);
  }
  Search() {
    if (this.teamName != "") {
  this.tabStage = this.tabStage.filter(response => {return response.teamName.toLocaleLowerCase().match(this.teamName.toLocaleLowerCase());
        });
  
    }
    else if (this.teamName == "" ){
        this.ngOnInit();
    }
  }
}
