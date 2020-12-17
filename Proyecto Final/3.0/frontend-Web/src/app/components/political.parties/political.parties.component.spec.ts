import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Political.PartiesComponent } from './political.parties.component';

describe('Political.PartiesComponent', () => {
  let component: Political.PartiesComponent;
  let fixture: ComponentFixture<Political.PartiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Political.PartiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Political.PartiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
