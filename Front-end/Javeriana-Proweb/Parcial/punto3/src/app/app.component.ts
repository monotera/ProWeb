import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  lista:string[]=["Pan","Pollo","Carne", "Tomate", "Lechuga"];
  seleccionados:string[]=[];
  seleccionados2:string[]=[];
  lista2:string[] =[]

  addElement = () => {
      this.lista2.push(...this.seleccionados)
      this.lista = this.lista.filter(el => {
        return !this.seleccionados.includes(el)
      })
      this.seleccionados = []
  }

  removeElement = () => {
    this.lista.push(...this.seleccionados2)
    this.lista2 = this.lista2.filter(el => {
      return !this.seleccionados2.includes(el)
    })
    this.seleccionados2 = []
  }

  constructor(){}

  ngOnInit(){}


}
