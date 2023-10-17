import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { PostControllerService } from 'src/api/postController.service';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserControllerService } from 'src/api/userController.service';
import { FavouriteControllerService } from 'src/api/favouriteController.service';
import { ImageControllerService } from 'src/api/imageController.service';
import { OfferControllerService } from 'src/api/offerController.service';
import { ReviewControllerService } from 'src/api/reviewController.service';
import { PostFormComponent } from './post-form/post-form.component';
import { DebugComponent } from './debug/debug.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationFormComponent,
    PostFormComponent,
    DebugComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    PostControllerService,
    UserControllerService,
    FavouriteControllerService,
    ImageControllerService,
    OfferControllerService,
    ReviewControllerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
