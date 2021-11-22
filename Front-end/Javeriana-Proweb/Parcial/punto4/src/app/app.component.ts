import { Component } from '@angular/core';
import { Album } from './model/album';
import { AlbumService } from './shared/album.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'punto4';
  info:Album[] = []
  mainUrl:string = ""

  constructor(
    private albumService:AlbumService
  ){}

  ngOnInit() {
    this.albumService.loadData().subscribe(data => {
      this.info = data
      this.mainUrl = data[0].url
    })
  }

  changePhoto(url:string){
    this.mainUrl = url;
  }

}
