import { Component, OnInit } from '@angular/core';
import { ItemService } from '../../services/item.service';
import { Item } from '../../models/item';
import { Router} from '@angular/router';

@Component({
  selector: 'app-items-list',
  templateUrl: './items-list.component.html',
  styleUrls: ['./items-list.component.css']
})
export class ItemsListComponent implements OnInit {

  public selectedItem: Item;
  public items: Item[];

  constructor(
    private itemService: ItemService,
    private router: Router,
  ) {

   }

  onSelect(item: Item) {
    this.selectedItem = item;
    this.router.navigate(['/itemDetails', this.selectedItem.id]);
  }

  reportMalfunction(item: Item) {
    this.selectedItem = item;
    this.itemService.reportMalfunction(item.id).subscribe(
      res => {
        this.selectedItem = res.json();
      },
      error => {
        console.log(error.text());
      }
    );
  }

  ngOnInit() {
    this.itemService.retrieveItems().subscribe(
      res => {
        this.items = res.json();
      },
      error => {
        console.log(error.text());
      }
    );
  }
}
