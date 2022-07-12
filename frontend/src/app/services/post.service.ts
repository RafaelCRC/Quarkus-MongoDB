import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const endPoint: string = 'http://localhost:8080/posts';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

  createPost(post: Object): Observable<any> {
    return this.http.post<Object>(endPoint, post);
  }

  getPosts(): any {
    return this.http.get(endPoint);
  }
}
