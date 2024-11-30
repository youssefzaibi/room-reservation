import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { StorageService } from './storage.service';
import { environment } from '../../environments/environment';

import { Category } from '../models/category';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root',
})
export class CategoryService {
  currentUserStorage: any;

  constructor(
    private http: HttpClient,
    private storageService: StorageService
  ) {}

  getAllCategories(): Observable<any> {
    this.currentUserStorage = this.storageService.getUser();
    let accessToken = this.currentUserStorage['access_token'];
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${accessToken}`,
    });

    return this.http.get(API_URL + 'category/all', { headers: headers });
  }

  getCategoryById(id: string): Observable<any> {
    this.currentUserStorage = this.storageService.getUser();
    let accessToken = this.currentUserStorage['access_token'];
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${accessToken}`,
    });

    return this.http.get(API_URL + 'category/find/' + id, { headers: headers });
  }

  createCategory(category: Category): Observable<Category> {
    this.currentUserStorage = this.storageService.getUser();
    let accessToken = this.currentUserStorage['access_token'];
    const httpOptions = {
      headers: new HttpHeaders().set('Content-Type', 'application/json').set(
        'Authorization',
        `Bearer ${accessToken}`
      ),
    };

    return this.http.post<Category>(
      API_URL + 'category/add',
      category,
      httpOptions
    );
  }

  updateCategory(id: string, category: Category): Observable<Category> {
    this.currentUserStorage = this.storageService.getUser();
    let accessToken = this.currentUserStorage['access_token'];
    const httpOptions = {
      headers: new HttpHeaders().set('Content-Type', 'application/json').set(
        'Authorization',
        `Bearer ${accessToken}`
      ),
    };

    return this.http.put<Category>(
      API_URL + 'category/update',
      category,
      httpOptions
    );
  }

  deleteCategoryById(id: string): Observable<number> {
    this.currentUserStorage = this.storageService.getUser();
    let accessToken = this.currentUserStorage['access_token'];
    const httpOptions = {
      headers: new HttpHeaders().set('Content-Type', 'application/json').set(
        'Authorization',
        `Bearer ${accessToken}`
      ),
    };

    return this.http.delete<number>(
      API_URL + 'category/delete/' + id,
      httpOptions
    );
  }

  deleteRecords(selectedRecordsToDelete: Category[]): Observable<string> {
    this.currentUserStorage = this.storageService.getUser();
    let accessToken = this.currentUserStorage['access_token'];
    const httpOptions = {
      headers: new HttpHeaders().set('Content-Type', 'application/json').set(
        'Authorization',
        `Bearer ${accessToken}`
      ),
    };

    return this.http.post<string>(
      API_URL + 'category/deleterecords',
      selectedRecordsToDelete,
      httpOptions
    );
  }  
}
