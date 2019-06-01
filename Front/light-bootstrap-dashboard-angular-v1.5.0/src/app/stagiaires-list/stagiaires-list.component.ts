import { StagiaireService } from './../tables/stagiaire.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-stagiaires-list',
  templateUrl: './stagiaires-list.component.html',
  styleUrls: ['./stagiaires-list.component.scss']
})
export class StagiairesListComponent implements OnInit {
  stagiaires: Array<any>;
  constructor(private stagiaireService: StagiaireService) { }

  ngOnInit() {
    this.stagiaireService.getAll().subscribe(data => {
      this.stagiaires = data;
    });
  }
 }
