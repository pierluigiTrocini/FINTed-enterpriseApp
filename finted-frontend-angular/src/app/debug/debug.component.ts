import { Component } from '@angular/core';
import { PostControllerService } from 'src/api/postController.service';
import { UserControllerService } from 'src/api/userController.service';

@Component({
  selector: 'app-debug',
  templateUrl: './debug.component.html',
  styleUrls: ['./debug.component.css']
})
export class DebugComponent {
  constructor( private userService: UserControllerService, private postService: PostControllerService ){}

  getAll(): void {
    this.userService.getAll(0).subscribe(res => console.log(res))
    this.postService.getAll1(0).subscribe(res => console.log(res))
  }
}
