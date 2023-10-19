import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostListVisualizationComponent } from './post-list-visualization.component';

describe('PostListVisualizationComponent', () => {
  let component: PostListVisualizationComponent;
  let fixture: ComponentFixture<PostListVisualizationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PostListVisualizationComponent]
    });
    fixture = TestBed.createComponent(PostListVisualizationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
