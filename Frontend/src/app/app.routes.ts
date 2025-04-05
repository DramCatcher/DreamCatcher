import { Routes } from '@angular/router';
import { TraumListComponent } from './pages/traum-list/traum-list.component';
import { TraumEditorComponent } from './pages/traum-editor/traum-editor.component';

export const routes: Routes = [
  { path: '', component: TraumListComponent },
  { path: 'neu', component: TraumEditorComponent }
];
