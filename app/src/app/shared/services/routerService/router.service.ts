
import { NavigationExtras, Router } from '@angular/router';

export class RouterService {

    constructor(private router: Router) {
        this.router.setUpLocationChangeListener();
    }

    public navigate = (url: string, opts?: NavigationExtras ) => {
        return this.router.navigateByUrl(url, opts);
    }

    public navigateBack = () => {
        window.history.back();
    }
}
