import { Component, OnInit } from '@angular/core';
import {NgForm } from '@angular/forms'
import { User } from './../shared/User'


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})


export class UserComponent implements OnInit {
  
  
  

  user: User;

  constructor() {

  }

  ngOnInit() {
    
  }

  saveStagiaire(stagiaireForm: NgForm): void {
    this.user=stagiaireForm.value;
    console.log(this.user);
    

  }
    
  }
  


