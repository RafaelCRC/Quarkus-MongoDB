import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from '../model/post';

const endPoint: string = 'http://localhost:8080/posts';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

  createPost(post: Post): Observable<Post> {
    return this.http.post<Object>(endPoint, post);
  }

  getPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(endPoint);
  }
}
