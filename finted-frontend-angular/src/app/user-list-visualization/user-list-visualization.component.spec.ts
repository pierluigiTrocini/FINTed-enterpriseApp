import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserListVisualizationComponent } from './user-list-visualization.component';

describe('UserListVisualizationComponent', () => {
  let component: UserListVisualizationComponent;
  let fixture: ComponentFixture<UserListVisualizationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserListVisualizationComponent]
    });
    fixture = TestBed.createComponent(UserListVisualizationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
