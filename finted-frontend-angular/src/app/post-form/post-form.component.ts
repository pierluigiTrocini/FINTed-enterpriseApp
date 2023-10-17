import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { catchError, of, throwError } from 'rxjs';
import { ImageControllerService } from 'src/api/imageController.service';
import { PostControllerService } from 'src/api/postController.service';
import { ImagePublishDto } from 'src/model/imagePublishDto';
import { PostDto } from 'src/model/postDto';
import { PostPublishDto } from 'src/model/postPublishDto';

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.css'],
})
export class PostFormComponent implements OnInit {
  postForm!: FormGroup;

  constructor(private postService: PostControllerService, private imageService: ImageControllerService) {}

  ngOnInit(): void {
    this.postForm = new FormGroup({
      title: new FormControl('', Validators.required),
      startingPrice: new FormControl(0, [Validators.min(0)]),
      image: new FormControl(null),
    });
  }

  handleError(error: HttpErrorResponse) {
    alert(`Errore: ${error.message}`);
    return of({ error: true, message: error.message });
  }

  isPostDto(object: { error: boolean; message: string; } | PostDto): object is PostDto {
    return (object as PostDto).id !== undefined;
  }

  onSubmit(): void {
    let newPost: PostPublishDto = {
      title: this.postForm.get('title')?.value,
      startingPrice: this.postForm.get('startingPrice')?.value,
      postImages: this.postForm.get('image')?.value,
      seller: {
        id: 0,
      },
    };

    this.postService
      .save2(newPost)
      .pipe(catchError(this.handleError))
      .subscribe((response) => {console.log(response)});
  }
}
