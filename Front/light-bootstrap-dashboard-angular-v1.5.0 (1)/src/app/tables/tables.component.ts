import { Component, OnInit } from '@angular/core';
import { StagiaireService } from '../shared/stagiaire/stagiaire.service';
 declare interface TableData {
    headerRow: string[];
    dataRows: string[][];
}

@Component({
  selector: 'app-tables',
  templateUrl: './tables.component.html',
  styleUrls: ['./tables.component.css']
})
export class TablesComponent implements OnInit {
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
}
