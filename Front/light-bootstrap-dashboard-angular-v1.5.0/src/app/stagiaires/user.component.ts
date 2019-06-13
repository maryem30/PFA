import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms'
import { StagiaireService } from './stagiaire.service';
import {Router} from '@angular/router';
import { User } from './../shared/User';




@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  
  

  
  public tabStag: Array <any>;
  stagiaireForm : FormGroup;
  click: string;
  email : String;
  password : String;
  nom: String;
  prenom : String;
  cin : String;
  tel : String;
  public tabStag2: User[];


  constructor(private  stagiaireService: StagiaireService,private router: Router) {

  }

  ngOnInit() {
    this.stagiaireService.currentMessage.subscribe(message => this.tabStag2 = message);
    this.stagiaireService.bool.subscribe(message => this.click = message)  
    if(this.click=="modifier"){
    this.email = this.tabStag2['email'];
    this.password = this.tabStag2['password'];
    this.nom = this.tabStag2['nom'];
    this.prenom = this.tabStag2['prenom'];
    this.cin = this.tabStag2['cin'];
    this.tel = this.tabStag2['tel'];
    }else{
      this.email = null;
      this.password = null;
      this.nom = null;
      this.prenom = null;
      this.cin = null;
      this.tel = null;
    }
    console.log(this.click);
    

  }

affiche() {
    this.stagiaireService.getAll().subscribe(data => {
        this.tabStag = data;

}
)
}
  

  saveStagiaire(data): void {
    const user= data.value;
    if(this.click=="ajouter"){
        this.stagiaireService.add(user).subscribe(
      res=>{
        this.affiche();
      }
    );
    }
    else{
        this.stagiaireService.updateSatgiaire(user).subscribe(
      res=>{
        this.affiche();
      }
    );
    }
    console.log(user.type);
    this.router.navigate(['/move']);


    
  }

    
  }
  


