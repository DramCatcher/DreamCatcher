import { Component, OnInit } from '@angular/core';
import { CommonModule, NgOptimizedImage } from '@angular/common';
import { TraumService } from '../../services/traum.service';
import { Traum } from '../../models/traum';
import { TraumCardComponent } from '../../components/traum-card/traum-card.component';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-traum-list',
  standalone: true,
  imports: [CommonModule, TraumCardComponent, RouterModule, NgOptimizedImage],
  templateUrl: './traum-list.component.html',
  styleUrls: ['./traum-list.component.scss']
})
export class TraumListComponent implements OnInit {
  traeume: Traum[] = [];

  constructor(private traumService: TraumService) {}

  ngOnInit(): void {
    this.traeume = this.traumService.getAll();
  }

  loeschen(index: number) {
    if (confirm('Diesen Traum wirklich löschen?')) {
      this.traumService.delete(index);
      this.traeume = this.traumService.getAll();
    }
  }

}
