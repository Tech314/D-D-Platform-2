
import { Injectable } from '@angular/core';

@Injectable()
export class StorageService {

    saveToSessionStorage(key: string, value: string) {
        sessionStorage.setItem(key, value);
    }

    retrieveFromStorage(key: string) {
        sessionStorage.getItem(key);
    }

    removeFromStorage(key: string) {
        sessionStorage.removeItem(key);
    }

    clearStorage() {
        sessionStorage.clear();
    }
}
