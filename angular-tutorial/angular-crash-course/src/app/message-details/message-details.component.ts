import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-message-details',
  standalone: true,
  imports: [],
  templateUrl: './message-details.component.html',
  styleUrl: './message-details.component.scss'
})
export class MessageDetailsComponent {

  @Input()
  message: any = {};
  @Input()
  index: number = -1;

  @Output()
  delete: EventEmitter<number> = new EventEmitter();
  onDelete() {
    this.delete.emit(this.index);

  }
}
