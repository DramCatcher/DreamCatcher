import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { TraumService } from '../../services/traum.service';
import { Traum } from '../../models/traum';

@Component({
  selector: 'app-traum-editor',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './traum-editor.component.html',
  styleUrls: ['./traum-editor.component.scss']
})
export class TraumEditorComponent {
  titel = '';
  inhalt = '';
  bild = ''; // z.B. Platzhalter oder AI-Bild später

  constructor(private traumService: TraumService, private router: Router) {}

  speichern() {
    const traum: Traum = {
      titel: this.titel,
      inhalt: this.inhalt,
      bild: this.bild,
      datum: new Date().toISOString()
    };

    this.traumService.add(traum);
    this.router.navigate(['/']); // Zurück zur Liste
  }
}
