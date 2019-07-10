import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms'
import { UserService } from './stagiaire.service';
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
  public tabStag2: FormGroup;


  constructor(private  stagiaireService: UserService,private router: Router) {

  }

  ngOnInit() {
    this.stagiaireService.currentMessage.subscribe((message : FormGroup) => this.tabStag2 = message);
    this.stagiaireService.bool.subscribe(message => this.click = message)  
   
      this.email = null;
      this.password = null;
      this.nom = null;
      this.prenom = null;
      this.cin = null;
      this.tel = null;
    
      console.log("ajouter")

    

  }

affiche() {
    this.stagiaireService.getAll().subscribe(data => {
        this.tabStag = data;

}
)
}
  

  saveStagiaire(data): void {
    const user= data.value;

        this.stagiaireService.add(user).subscribe(
      res=>{
        this.affiche();
      }
    );
    this.router.navigate(['/move']);

    console.log(data.value)
    
  }

    
  }
  


