import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LandingRouterModule } from './landing-router.module';
import { LandingPageComponent } from './landing-page/landing-page.component';

@NgModule({
  declarations: [LandingPageComponent],
  imports: [
    CommonModule,
    LandingRouterModule
  ]
})
export class LandingModule { }
