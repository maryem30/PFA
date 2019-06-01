import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder,Validators,ReactiveFormsModule } from '@angular/forms'
import { User } from './../shared/User'


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})


export class UserComponent implements OnInit {
  
  
  

  user: User;
  userForm: FormGroup;

  
  

  constructor( private fb: FormBuilder) { 
    this.userForm = this.fb.group({
      email:['',Validators.required],
      Password:'',
      First_Name:'',
      Last_Name:'',
      cin:''

    });
  }

  ngOnInit() {
    
  }

  addUser(){
    this.user= this.userForm.value;
    
    
  }
  

}
