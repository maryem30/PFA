import { Component, OnInit } from '@angular/core';
import {NgForm, FormGroup } from '@angular/forms'
import { User } from './../shared/User'
import { StagiaireService } from './stagiaire.service';



@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit {
  
  
  

  
  public tabStag: Array <any>;
  stagiaireForm : FormGroup


  constructor(private  stagiaireService: StagiaireService) {

  }

  ngOnInit() {
    
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
    console.log(user);
    
  }

    
  }
  


