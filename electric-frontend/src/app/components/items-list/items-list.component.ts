import { Component, OnInit } from '@angular/core';
import { ItemService } from '../../services/item.service';
import { Item } from '../../models/item';
import {Params, ActivatedRoute, Router} from '@angular/router';
import {Http} from '@angular/http';

@Component({
  selector: 'app-items-list',
  templateUrl: './items-list.component.html',
  styleUrls: ['./items-list.component.css']
})
export class ItemsListComponent implements OnInit {

  private selectedItem: Item;
	private items: Item[];

  constructor(
    private itemService: ItemService,
    private router: Router,
    private http: Http,
    private route: ActivatedRoute
  ) {

   }

   onSelect(item: Item) {
		this.selectedItem = item;
		this.router.navigate(['/itemDetail', this.selectedItem.id]);
	}
  
	ngOnInit() {
    this.itemService.retrieveItems().subscribe(
      res => {
        console.log(res);
        this.items = res.json();
      },
      error => {
        console.log(error.text());
      }
    )
	}
}
