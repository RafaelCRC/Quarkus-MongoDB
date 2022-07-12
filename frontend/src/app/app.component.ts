import { Component, OnInit } from '@angular/core';
import { PostService } from './services/post.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit { //tirar tudo isso dps

  constructor(private postService: PostService) {}

  ngOnInit(): void {
    this.listPosts();
  }

  private listPosts() {
    this.postService.getPosts().subscribe((data: any) => console.log(data));
  }

  title = 'frontend';
}
