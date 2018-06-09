import { Component, OnInit } from '@angular/core';
import { Item } from '../../models/item';
import { ItemService } from '../../services/item.service';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { Http } from '@angular/http';

@Component({
  selector: 'app-item-details',
  templateUrl: './item-details.component.html',
  styleUrls: ['./item-details.component.css']
})
export class ItemDetailsComponent implements OnInit {

  private item: Item = new Item();
  private comment: Comment = new Comment();
  private itemId: number;

  constructor(
    private itemService: ItemService,
    private router: Router,
    private http: Http,
    private route: ActivatedRoute
    ) { }

  postComment(itemId: number) {
    this.itemService.postComment(this.itemId, this.comment).subscribe(
      res => {
        this.item.comments = res.json();
      },
      error => {
        console.log(error.text());
      }
    );
  }

  ngOnInit() {
    this.route.params.forEach((params: Params) => {
  		this.itemId = Number.parseInt(params['id']);
    });

    this.itemService.retrieveSpecificItem(this.itemId).subscribe(
      res => {
        console.log(res);
        this.item = res.json();
      },
      error => {
        console.log(error.text());
      }
    )
  }
}
