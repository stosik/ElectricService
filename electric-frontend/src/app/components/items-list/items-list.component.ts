import { Component, OnInit } from '@angular/core';
import { ItemService } from '../../services/item.service';
import { Item } from '../../models/item';

@Component({
  selector: 'app-items-list',
  templateUrl: './items-list.component.html',
  styleUrls: ['./items-list.component.css']
})
export class ItemsListComponent implements OnInit {

  private selectedItem: Item;
	private items: Item[];

  constructor() { }

  tiles = [
    {text: 'Shiba', cols: 1, rows: 2, color: 'lightgreen'},

    {text: 'Doggy', cols: 1, rows: 2, color: 'lightpink'},
    {text: 'Dog', cols: 1, rows: 2, color: '#DDBDF1'},
    {text: 'Doggo', cols: 1, rows: 2, color: '#DDBDF1'},
    {text: 'Doge', cols: 1, rows: 2, color: '#DDBDF1'},
    {text: 'Some Dog', cols: 1, rows: 2, color: '#DDBDF1'},
    {text: 'Text', cols: 1, rows: 2, color: '#DDBDF1'},
  ];
  
  ngOnInit() {
  }

}
