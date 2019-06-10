import { Component, OnInit } from '@angular/core';
import { StagiaireService } from './stagiaire.service';
import { User } from './../shared/User';
import * as jsPDF from 'jspdf'

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
    public nom : String;
    public contractTypeValid = "False";
    private page:number = 0;
    private pages:Array<any>;
    private i:number;
    public tabStag1: any = {};


  constructor(private  stagiaireService: StagiaireService) { }

  ngOnInit() {
    this.getSatgiairePage();
} 
setPage(i,event:any){
  this.i=i;
  event.preventDefault();
  this.page=i;
  this.getSatgiairePage();
} 
    
    
affiche() {
    this.stagiaireService.getAll().subscribe(data => {
        this.tabStag = data;

});
}

getSatgiairePage(){
  this.stagiaireService.getSatgiaire(this.page).subscribe(data =>{
    this.tabStag = data['content'];
    this.pages= new Array(data['totalPages']);
  });
}

deleteStag(id){
  this.stagiaireService.deleteStag(id).subscribe((response => {console.log(response); this.stagiaireService.getAll().subscribe(data=>{this.tabStag = data;})

  }));
  this.getSatgiairePage();
  
  
}
toPDF(){
  const doc = new jsPDF();
  doc.text("hello word",15,15);
  doc.save("firstPDF.pdf")
}

Search(){
  if (this.nom != "") {
      this.tabStag = this.tabStag.filter(response => {return response.nom.toLocaleLowerCase().match(this.nom.toLocaleLowerCase());
      });

  }
  else if (this.nom == "" ){
      this.ngOnInit();
  }
}
getById(id : String){
  this.stagiaireService.getById(id).subscribe(data => {
    this.tabStag1 = data ;
    
  
});
this.ngOnInit();
console.log(this.tabStag1)
console.log(id);

}

}
