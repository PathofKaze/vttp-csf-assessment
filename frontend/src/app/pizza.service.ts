// Implement the methods in PizzaService for Task 3
// Add appropriate parameter and return type 

import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom } from "rxjs";
import { orderDetails, orderList } from "src/app/models";



@Injectable()
export class PizzaService {

  constructor(private http: HttpClient) { }

  // POST /api/order
  // Add any required parameters or return type
  createOrder(ord: orderDetails): Promise<orderDetails> {

    const headers = new HttpHeaders()
    .set('Content-Type', 'application/json')
    .set('Accept', 'application/json')
    
    return firstValueFrom(
      this.http.post<orderDetails>('/api/orders', ord, {headers})
    )
  }


  // GET /api/order/<email>/all
  // Add any required parameters or return type
  getOrders(email: string): Promise<orderList> {
    const params = new HttpParams()
        .set("email", email)

    return firstValueFrom(
      this.http.get<orderList>(`/api/orders/${email}`)
    )
  }
}
