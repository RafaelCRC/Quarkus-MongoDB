import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/model/post';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-show-post',
  templateUrl: './show-post.component.html',
  styleUrls: ['./show-post.component.scss']
})
export class ShowPostComponent implements OnInit {

  post: Post | any;
  posts: Post[] | any;

  constructor(private postService: PostService) {}

  ngOnInit(): void {
    this.listPosts();
  }

  private listPosts() {
    this.postService.getPosts().subscribe((data: Post[]) => this.posts = data);
  }

}
