import {Component, OnInit} from '@angular/core';
import {ProductService} from "../services/api/products/product.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-about',
  standalone: true,
  imports: [],
  templateUrl: './about.component.html',
  styleUrl: './about.component.scss'
})
export class AboutComponent implements OnInit {

  constructor(
    private service: ProductService
  ) {
  }

  ngOnInit(): void {
        this.service.getAllProductsWithLimit()
          .subscribe({
            next: data => {
              console.log(data);

            }
          })
    }
}
