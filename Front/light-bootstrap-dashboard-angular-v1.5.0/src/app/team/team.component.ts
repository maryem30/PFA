import { Component, OnInit } from '@angular/core';
import { User } from './../shared/User'
import { TeamService } from './team.service';

declare interface TableData {
  headerRow: string[];
  dataRows: string[][];
}

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.scss']
})
export class TeamComponent implements OnInit {

  public user : User;
  public tableData1: TableData;
  public tableData2: TableData;
  public tabTeam: Array <any>;
  public nom : String;
  public contractTypeValid = "False";
  private page:number = 0;
  private pages:Array<any>;
  private i:number;

  constructor(private  teamService: TeamService) { }

  ngOnInit() {
    this.getTeamPage();
  }
  setPage(i,event:any){
    this.i=i;
    event.preventDefault();
    this.page=i;
    this.getTeamPage();
  }
  affiche() {
      this.teamService.getAll().subscribe(data => {
          this.tabTeam = data;
  
  });
  }
  
  getTeamPage(){
    this.teamService.getTeam(this.page).subscribe(data =>{
      this.tabTeam = data['content'];
      this.pages= new Array(data['totalPages']);
    });
  }
  
  deleteTeam(id,i,event:any){
    this.teamService.deleteTeam(id).subscribe((response =>{console.log(response); this.teamService.getAll().subscribe(data=>{this.tabTeam = data;})
  
    }));
    this.setPage(i,event);
  }
  
  Search(){
    if (this.nom != "") {
        this.tabTeam = this.tabTeam.filter(response => {return response.nom.toLocaleLowerCase().match(this.nom.toLocaleLowerCase());
        });
  
    }
    else if (this.nom == "" ){
        this.ngOnInit();
    }
  }
  
}
