import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { orderList } from '../models';
import { PizzaService } from '../pizza.service';

@Component({
  selector: 'app-orders-component',
  templateUrl: './orders-component.component.html',
  styleUrls: ['./orders-component.component.css']
})
export class OrdersComponent implements OnInit {

  email!: string
  orders!: orderList

  constructor(private activatedRoute: ActivatedRoute, private title: Title,
    private pzaSvc: PizzaService) { }

  ngOnInit(): void {
    this.orders = {
      email: '',
      orderid: '',
      price: ''
    }
    this.email = this.activatedRoute.snapshot.params['email']
    this.title.setTitle(`email: ${this.email}`)

    this.pzaSvc.getOrders(this.email)
      .then(result => {
        console.info('>>> orders: ', result)
        this.orders = result
      })
      .catch(error => {
        console.error('>>>> error: ', error)
      })
  }
}