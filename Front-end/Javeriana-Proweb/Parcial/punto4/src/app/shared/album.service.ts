import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Album } from '../model/album';

@Injectable({
  providedIn: 'root'
})
export class AlbumService {

  constructor(private http: HttpClient) { }

  loadData():Observable<Album[]>{
    return this.http.get<Album[]>("http://jsonplaceholder.typicode.com/albums/1/photos")
  }
}
