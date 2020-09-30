import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class TranslationService {

    content = new BehaviorSubject<any>(undefined);

    setLanguage(language: any) {
        this.content.next(language);
    }

    getLanguage() {
        return this.content.asObservable();
    }
}
