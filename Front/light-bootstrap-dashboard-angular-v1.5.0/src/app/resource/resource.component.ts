import { Component, OnInit } from '@angular/core';
import { ResourceService } from './resource.service';
import {Router} from '@angular/router';
import { FormGroup } from '@angular/forms';


 declare interface TableData {
    headerRow: string[];
    dataRows: string[][];
}
@Component({
  selector: 'app-resource',
  templateUrl: './resource.component.html',
  styleUrls: ['./resource.component.scss']
})
export class ResourceComponent implements OnInit {

  


  public tableData1: TableData;
  public tableData2: TableData;
  public tabStag: Array <any>;
  public tabStag1: FormGroup;
  public nom : String;
  public prenom: String;
  public cin : String;
  public email : String;
  public tel : String;
  public contractTypeValid = "False";
  private page:number = 0;
  private pages:Array<any>;
  private i:number;
  
  


constructor(private  resourceService: ResourceService,private router: Router ) { 
  
}

ngOnInit() {
  
  this.getResourcePage(); 
} 
setPage(i,event:any){
this.i=i;
event.preventDefault();
this.page=i;
this.getResourcePage(); 
} 
  
  
affiche() {
  this.resourceService.getAll().subscribe(data => {
      this.tabStag = data;

});
}

getResourcePage(){
this.resourceService.getRes(this.page).subscribe(data =>{
  this.tabStag = data['content'];
  this.pages= new Array(data['totalPages']);
});
} 
ajouter(){
this.resourceService.changeClick("ajouter");
this.router.navigate(['/user']);

}

update(id){
this.resourceService.getById(id).subscribe( (data:FormGroup)  => {
  this.tabStag1 = data;
  this.resourceService.changeMessage(this.tabStag1);
  this.resourceService.changeClick("modifier");
  console.log(id);
  this.tabStag1['id']=id;
  console.log(this.tabStag1);
  
  this.router.navigate(['/updateStagiaire']);
  });
  
}

deleteRes(id){
this.resourceService.deleteRes(id).subscribe((response => {console.log(response); this.resourceService.getAll().subscribe(data=>{this.tabStag = data;})

}));
/*this.getSatgiairePage(); */


}


SearchByNom(){
if (this.nom != "") {
    this.tabStag = this.tabStag.filter(response => {return response.nom.toLocaleLowerCase().match(this.nom.toLocaleLowerCase());
    });
  }

  else if (this.nom == "" ){ 
      this.ngOnInit();
  }


}

SearchByPrenom(){
if (this.prenom != "") {
    this.tabStag = this.tabStag.filter(response => {return response.prenom.toLocaleLowerCase().match(this.prenom.toLocaleLowerCase());
    });

}
else if (this.prenom == "" ){
    this.ngOnInit();
}
}

SearchByEmail(){
if (this.email != "") {
    this.tabStag = this.tabStag.filter(response => {return response.email.toLocaleLowerCase().match(this.email.toLocaleLowerCase());
    });

}
else if (this.email == "" ){
    this.ngOnInit();
}
}
SearchByTel(){
if (this.tel != "") {
    this.tabStag = this.tabStag.filter(response => {return response.tel.toLocaleLowerCase().match(this.tel.toLocaleLowerCase());
    });

}
else if (this.tel == "" ){
    this.ngOnInit();
}
}

}


