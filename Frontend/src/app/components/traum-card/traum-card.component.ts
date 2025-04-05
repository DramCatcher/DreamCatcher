import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-traum-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './traum-card.component.html',
  styleUrls: ['./traum-card.component.scss']
})
export class TraumCardComponent {
  @Input() titel: string = '';
  @Input() inhalt: string = '';
  @Input() bild: string = '';
  @Input() datum: string = '';

  @Output() delete = new EventEmitter<void>();

  onDelete() {
    this.delete.emit();
  }
}
