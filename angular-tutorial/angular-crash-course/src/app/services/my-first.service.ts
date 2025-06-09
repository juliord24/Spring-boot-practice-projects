import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MyFirstService {

  messages: Array<any> = [];

  constructor() {
    this.init();
  }

  init(): void {

    this.insert({
      name: 'Julio',
      email: 'julio@gmail.com',
      message: 'Hello world'
    })
    this.insert({
      name: 'Jhon',
      email: 'jhon@gmail.com',
      message: 'Hello world jhon'
    })
    this.insert({
      name: 'Ali',
      email: 'Ali@gmail.com',
      message: 'Hello world ali'
    })
  }

  insert(message: {name: string, email: string, message: string}): void {
    this.messages.push(message);
  }

  getAllMessages(): any[] {
    return this.messages;
  }

  deleteMessage(index: number) {
    this.messages.splice(index, 1);
  }
}
