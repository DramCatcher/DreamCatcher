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
  bild = '';
  loading = false;

  constructor(private traumService: TraumService, private router: Router) {}

  async visualisieren() {
    if (!this.inhalt.trim()) return;
    this.loading = true;

    const encodedPrompt = encodeURIComponent(this.inhalt);
    const bildUrl = `https://image.pollinations.ai/prompt/${encodedPrompt}`;

    // Warte, bis das Bild geladen ist
    const img = new Image();
    img.src = bildUrl;

    await new Promise((resolve) => {
      img.onload = () => resolve(true);
      img.onerror = () => resolve(true); // zur Sicherheit
    });

    this.bild = bildUrl;
    this.loading = false;
  }

  speichern() {
    const traum: Traum = {
      titel: this.titel,
      inhalt: this.inhalt,
      bild: this.bild,
      datum: new Date().toISOString()
    };

    this.traumService.add(traum);
    this.router.navigate(['/']);
  }
}
