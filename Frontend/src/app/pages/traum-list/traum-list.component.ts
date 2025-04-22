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

  constructor(private traumService: TraumService) {
  }

  ngOnInit(): void {
    this.loadDreams()
  }

  loadDreams() {
    this.traumService.getAll().subscribe(traume => {
      this.traeume = traume
    });
  }

  deleteDream(id?: number) {
    if (id && confirm('Diesen Traum wirklich löschen?')) {
      this.traumService.delete(id).subscribe({
        next: () => {
          this.loadDreams();
        },
        error: (err) => {
          console.error('Fehler beim Löschen:', err);
          alert('Fehler beim Löschen des Traums');
        }
      });
    }
  }

}
