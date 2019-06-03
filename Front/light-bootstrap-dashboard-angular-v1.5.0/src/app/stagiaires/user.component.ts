import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms'
import { StagiaireService } from './stagiaire.service';
import {Router} from '@angular/router';




@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  
  

  
  public tabStag: Array <any>;
  stagiaireForm : FormGroup


  constructor(private  stagiaireService: StagiaireService,private router: Router) {

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
    this.router.navigate(['/move']);


    
  }

    
  }
  


