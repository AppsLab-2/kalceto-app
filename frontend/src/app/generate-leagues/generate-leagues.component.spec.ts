import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenerateLeaguesComponent } from './generate-leagues.component';

describe('GenerateLeaguesComponent', () => {
  let component: GenerateLeaguesComponent;
  let fixture: ComponentFixture<GenerateLeaguesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GenerateLeaguesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GenerateLeaguesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
