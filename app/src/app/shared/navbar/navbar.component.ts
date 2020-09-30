import { Component, OnInit } from '@angular/core';
import { TranslationService } from '../services/translationService/translation.service';

@Component({
  selector: 'app-nav',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavComponent implements OnInit {

    languageContent: any;

  constructor(private translateService: TranslationService) {}

  ngOnInit() {
      this.translateService.getLanguage().subscribe(content => {
          this.languageContent = content;
      });
  }

}
