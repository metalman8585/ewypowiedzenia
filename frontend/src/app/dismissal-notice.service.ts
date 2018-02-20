import { Injectable } from '@angular/core';
import { DismissalNotice } from "./dismissal-notice";
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class DismissalNoticeService {

  private dismissalNoticeUrl = 'http://localhost:8080/generate';

  constructor(private http: HttpClient) { }

  generate(dismissalNotice: DismissalNotice): Observable<DismissalNotice> {
    return this.http.post<DismissalNotice>(this.dismissalNoticeUrl, dismissalNotice, httpOptions).pipe(
      catchError(this.handleError<DismissalNotice>('generateDismissalNotice'))
    );
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error); // log to console instead
      return of(result as T);
    };
  }

}
