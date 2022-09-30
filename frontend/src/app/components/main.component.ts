import { ThisReceiver } from '@angular/compiler';
import { Component, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { orderDetails } from '../models';

const SIZES: string[] = [
  "Personal - 6 inches",
  "Regular - 9 inches",
  "Large - 12 inches",
  "Extra Large - 15 inches"
]

const PizzaToppings: string[] = [
    'chicken', 'seafood', 'beef', 'vegetables',
    'cheese', 'arugula', 'pineapple'
]

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  pizzaSize = SIZES[0]

  @Output()
  onNeworder = new Subject<orderDetails>()


  orderForm!: FormGroup

  constructor(private fb: FormBuilder) { }


  ngOnInit(): void {
    this.orderForm = this.createForm()
  }

  private createForm() {
    return this.fb.group({
      name: this.fb.control("" , [ Validators.required, Validators.minLength(3) ]),
      email: this.fb.control("", [ Validators.required, Validators.email]),
      size: this.fb.control("", [ Validators.required, Validators.minLength(1) ]),
      base: this.fb.control("", [ Validators.required, Validators.minLength(3) ]),
      toppings: this.fb.control("", [ Validators.required, Validators.minLength(3) ]),
      comments: this.fb.control("")
    })
  }

  updateSize(size: string) {
    this.pizzaSize = SIZES[parseInt(size)]
  }

  checkOrder(){
    console.info('>>> Email:', this.orderForm.controls['email'].value)
  }

  processOrder() {
    console.info("Submit button clicked")
    console.info(">>> orderForm: ", this.orderForm.value)
    const ord: orderDetails = this.orderForm.value as orderDetails
    this.onNeworder.next(ord)
    this.orderForm = this.createForm()
  }

}

