import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreatePostComponent } from './create-post/create-post.component';
import { ShowPostComponent } from './show-post/show-post.component';



@NgModule({
  declarations: [
    CreatePostComponent,
    ShowPostComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    CreatePostComponent,
    ShowPostComponent
  ]
})
export class PostModule { }
