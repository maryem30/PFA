import { Component, OnInit } from '@angular/core';
import { UserService } from './stagiaire.service';
import {Router} from '@angular/router';
import { FormGroup } from '@angular/forms'
import { User } from './../shared/User';


@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.scss']
})
export class UserUpdateComponent implements OnInit {

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

  constructor(private  stagiaireService: UserService,private router: Router) { }

  ngOnInit() {
    this.stagiaireService.currentMessage.subscribe(message => this.tabStag2 = message);
    this.stagiaireService.bool.subscribe(message => this.click = message)  
    this.email = this.tabStag2['email'];
    this.password = this.tabStag2['password'];
    this.nom = this.tabStag2['nom'];
    this.prenom = this.tabStag2['prenom'];
    this.cin = this.tabStag2['cin'];
    this.tel = this.tabStag2['tel'];
    console.log("modifier")
  }

  affiche() {
    this.stagiaireService.getAll().subscribe(data => {
        this.tabStag = data;

}
)
}
  saveStagiaire(data,id): void {
    const user= data.value;
        user['id'] = id;

        this.stagiaireService.updateUser(id,user).subscribe(
      res=>{
        this.affiche();
      }
    );
    console.log(id)
    console.log(user)
    this.router.navigate(['/move']);

    
    
  }
}
