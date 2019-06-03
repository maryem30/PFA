import { Component, OnInit } from '@angular/core';
import { StagiaireService } from './stagiaire.service';
import { User } from './../shared/User'

 declare interface TableData {
    headerRow: string[];
    dataRows: string[][];
}

@Component({
  selector: 'app-tables',
  templateUrl: './stagiaire.component.html',
  styleUrls: ['./stagiaire.component.css']
})
export class TablesComponent implements OnInit {

    public user : User;
    public tableData1: TableData;
    public tableData2: TableData;
    public tabStag: Array <any>;

  constructor(private  stagiaireService: StagiaireService) { }

  ngOnInit() {
    this.stagiaireService.getAll().subscribe(data => {
        this.tabStag = data;

}
)
    
    }
    
affiche() {
    this.stagiaireService.getAll().subscribe(data => {
        this.tabStag = data;

}
)
}
deleteStag(id){
  this.stagiaireService.deleteStag(id).subscribe((response => {console.log(response); this.stagiaireService.getAll().subscribe(data=>{this.tabStag = data;})

   }))

}

}
