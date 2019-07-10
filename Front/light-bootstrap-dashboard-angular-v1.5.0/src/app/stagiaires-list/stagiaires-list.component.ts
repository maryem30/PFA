import { UserService } from './../stagiaires/stagiaire.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-stagiaires-list',
  templateUrl: './stagiaires-list.component.html',
  styleUrls: ['./stagiaires-list.component.scss']
})
export class StagiairesListComponent implements OnInit {
  public tabStag: Array <any>;
  stagiaires: Array<any>;
  constructor(private stagiaireService: UserService) { }

  ngOnInit() {
    this.stagiaireService.getAll().subscribe(data => {
      this.tabStag = data;

}
)

  }
 }
