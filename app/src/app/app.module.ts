import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavComponent } from './shared/navbar/navbar.component';
import { AppRoutingModule } from './app-routing.module';
import { TranslationService } from './shared/services/translationService/translation.service';
import { CookieService } from 'ngx-cookie-service';
import { HomeComponent } from './pages/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    TranslationService,
    CookieService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
