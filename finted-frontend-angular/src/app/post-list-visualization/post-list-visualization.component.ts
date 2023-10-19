import { Component, OnInit } from '@angular/core';
import { PostControllerService } from 'src/api/postController.service';
import { PostPublishDto } from 'src/model/postPublishDto';

@Component({
  selector: 'app-post-list-visualization',
  templateUrl: './post-list-visualization.component.html',
  styleUrls: ['./post-list-visualization.component.css']
})
export class PostListVisualizationComponent implements OnInit{
  constructor(private postService: PostControllerService){}

  getResults: PostPublishDto[] = []

  ngOnInit(): void {
    this.postService.getAll1(0)
      .subscribe(response => this.getResults = response)
  }

}
