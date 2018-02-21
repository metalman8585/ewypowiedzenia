import { Injectable } from '@angular/core';
import { DismissalNotice } from './dismissal-notice';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';

@Injectable()
export class DismissalNoticeService {

  private dismissalNoticeUrl = 'http://localhost:8080/generate';

  constructor(private http: HttpClient) { }

  generate(dismissalNotice: DismissalNotice): Observable<Blob> {
    return this.http.post(this.dismissalNoticeUrl, dismissalNotice, {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
      responseType: 'blob'
    }).pipe(
      catchError(this.handleError<Blob>('generateDismissalNotice'))
    );
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error); // log to console instead
      return of(result as T);
    };
  }

}
