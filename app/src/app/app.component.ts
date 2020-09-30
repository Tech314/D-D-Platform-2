import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { TranslationService } from './shared/services/translationService/translation.service';
import { environment } from 'src/environments/environment';
import { englishConstants } from './languageConstants/englishConstants';
import { spanishConstants } from './languageConstants/spanishConstants';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  constructor(
    private translationService: TranslationService,
    private cookieService: CookieService
    ) {}

  ngOnInit() {
    this.checkAndHandleLanguageCookie();
  }

  checkAndHandleLanguageCookie() {
    let language = this.cookieService.get('Pref_Lang');
    if (!language) {
      language = 'en';
      this.cookieService.set('Pref_Lang', 'en', new Date(20211212), '/', environment.cookieDomain);
    }

    this.translationService.setLanguage(language === 'en' ? englishConstants : spanishConstants);
  }
}
