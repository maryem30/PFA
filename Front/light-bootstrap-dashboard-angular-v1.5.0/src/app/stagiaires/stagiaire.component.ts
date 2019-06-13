import { Component, OnInit } from '@angular/core';
import { StagiaireService } from './stagiaire.service';
import { User } from './../shared/User';
import {Router} from '@angular/router';
import { FormGroup } from '@angular/forms';


 declare interface TableData {
    headerRow: string[];
    dataRows: string[][];
}

@Component({
  selector: 'app-tables',
  templateUrl: './stagiaire.component.html',
  styleUrls: ['./stagiaire.component.css'],
  
})


export class TablesComponent implements OnInit {

    public user : User;
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
    
    


  constructor(private  stagiaireService: StagiaireService,private router: Router ) { 
    
  }

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
ajouter(){
  this.stagiaireService.changeClick("ajouter");
  this.router.navigate(['/user']);

}

update(id){
  this.stagiaireService.getById(id).subscribe( (data:FormGroup)  => {
    this.tabStag1 = data;
    this.stagiaireService.changeMessage(this.tabStag1);
    this.stagiaireService.changeClick("modifier");
    console.log(id);
    this.tabStag1['id']=id;
    console.log(this.tabStag1);
    
    this.router.navigate(['/updateStagiaire']);
    });
    
}

deleteStag(id){
  this.stagiaireService.deleteStag(id).subscribe((response => {console.log(response); this.stagiaireService.getAll().subscribe(data=>{this.tabStag = data;})

  }));
  this.getSatgiairePage();
  
  
}

SearchByCin(){
  if (this.cin != "") {
      this.tabStag = this.tabStag.filter(response => {return response.cin.toLocaleLowerCase().match(this.cin.toLocaleLowerCase());
      });
    
  }
 
      else if (this.cin == ""  ){
        this.ngOnInit();
  }

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

