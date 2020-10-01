
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { RouterService } from 'src/app/shared/services/routerService/router.service';
import { TranslationService } from '../../shared/services/translationService/translation.service';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, OnDestroy {
    // tslint:disable-next-line: max-line-length
    image = 'https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fpop-verse.com%2Fwp-content%2Fuploads%2F2015%2F08%2FDungeons_and_Dragons_4th_Edition_Logo.jpg&f=1';
    beginnerCampaigns = 'http://www.dndadventure.com/html/adventures/adv1.html';

    private $language: Subscription;
    public constants: any;

    constructor(
        private translationService: TranslationService,
        private routerService: RouterService
    ) {}

    public ngOnInit() {
        this.$language = this.translationService.getLanguage().subscribe((constants) => {
            this.constants = constants;
        });
    }

    public ngOnDestroy() {
        if (this.$language) {
            this.$language.unsubscribe();
        }
    }

    public navigateTo(url: string) {
        this.routerService.navigate(url);
    }
}
