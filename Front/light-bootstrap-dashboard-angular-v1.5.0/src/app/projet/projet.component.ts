
import { Component, OnInit } from '@angular/core';
import { ProjetService } from './projet.service';
import {Router} from '@angular/router';
import { FormGroup } from '@angular/forms';
import { format } from 'url';


 declare interface TableData {
    headerRow: string[];
    dataRows: string[][];
}
@Component({
  selector: 'app-projet',
  templateUrl: './projet.component.html',
  styleUrls: ['./projet.component.scss']
})
export class ProjetComponent implements OnInit {

  public tableData1: TableData;
  public tableData2: TableData;
  public tabStag: Array <any>;
  public tabStag1: FormGroup;
  public nom : String;

  public dated : Date;
  public datef :Date ;
  

  private page:number = 0;
  private pages:Array<any>;
  private i:number;
  
  


constructor(private  projetService: ProjetService,private router: Router ) { 
  
}

ngOnInit() {
  
  this.getProjetPage(); 
} 
setPage(i,event:any){
this.i=i;
event.preventDefault();
this.page=i;
this.getProjetPage(); 
} 
  
  
affiche() {
  this.projetService.getAll().subscribe(data => {
      this.tabStag = data;

});
}

getProjetPage(){
this.projetService.getProj(this.page).subscribe(data =>{
  this.tabStag = data['content'];
  this.pages= new Array(data['totalPages']);
});
} 
ajouter(){
this.projetService.changeClick("ajouter");
this.router.navigate(['/user']);

}

update(id){
this.projetService.getById(id).subscribe( (data:FormGroup)  => {
  this.tabStag1 = data;
  this.projetService.changeMessage(this.tabStag1);
  this.projetService.changeClick("modifier");
  console.log(id);
  this.tabStag1['id']=id;
  console.log(this.tabStag1);
  
  this.router.navigate(['/updateStagiaire']);
  });
  
}

deleteProj(id){
this.projetService.deleteProj(id).subscribe((response => {console.log(response); this.projetService.getAll().subscribe(data=>{this.tabStag = data;})

}));
/*this.getSatgiairePage(); */


}




}


