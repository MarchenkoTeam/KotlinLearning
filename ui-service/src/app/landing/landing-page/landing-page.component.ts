import { Component, OnInit } from '@angular/core';
import { Theme } from '@app/entities';
import { ThemesService } from '@app/core/services/themes.service';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.scss']
})
export class LandingPageComponent implements OnInit {

  themes: Theme[];

  constructor(private themesService: ThemesService) {}

  ngOnInit() {
    this.themesService.getThemes()
      .subscribe(themes => this.themes = themes);
  }
}
