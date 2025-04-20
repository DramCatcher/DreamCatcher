import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink, RouterModule } from '@angular/router';
import { TraumService } from '../../services/traum.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-traum-editor',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink, RouterModule],
  templateUrl: './traum-editor.component.html',
  styleUrls: ['./traum-editor.component.scss']
})
export class TraumEditorComponent {
  titel = '';
  inhalt = '';
  bild = '';
  loading = false;
  versuchZuSpeichern = false;

  constructor(private traumService: TraumService, private router: Router, private http: HttpClient) {
  }

  async visualisieren() {
    if (!this.inhalt.trim()) return;
    this.loading = true;
    this.bild = ''

    const encodedPrompt = encodeURIComponent(this.inhalt);
    const imageUrl = `https://image.pollinations.ai/prompt/${encodedPrompt}`;
    this.http.get(imageUrl, { responseType: 'blob' }).subscribe(blob => {
      const reader = new FileReader();
      reader.onloadend = () => {
        this.bild = reader.result as string;
        this.loading = false;
      };
      reader.readAsDataURL(blob); // Convert to base64
    });
  }

  speichern() {
    this.versuchZuSpeichern = true;

    if (!this.titel.trim() || !this.inhalt.trim()) {
      return; // Fehlermeldung wird im HTML angezeigt
    }

    const formData = new FormData();
    formData.append('title', this.titel);
    formData.append('content', this.inhalt.trim());
    if (this.bild) {
      formData.append('img', this.base64ToFile(this.bild));
    }

    this.traumService.add(formData).subscribe(() => {
      this.router.navigate(['/']);
    });
  }

  base64ToFile(base64: string): File {
    const arr = base64.split(',');
    const mime = arr[0].match(/:(.*?);/)![1];
    const base64string = atob(arr[1]);
    let n = base64string.length;
    const uint8Array = new Uint8Array(n);

    while (n--) {
      uint8Array[n] = base64string.charCodeAt(n);
    }

    return new File([uint8Array], 'visualization.jpg', { type: mime });
  }
}
