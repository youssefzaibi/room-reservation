import { OnInit, Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

import { StorageService } from '../_services/storage.service';

import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})

export class ProfileComponent implements OnInit {
  content: any;
  isLoggedIn = false;
  errorMessage = '';

  constructor(
    private storageService: StorageService,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.isLoggedIn = this.storageService.isLoggedIn();

    this.userService.getUsers().subscribe({
      next: (data) => {
        this.content = data;
      },
      error: (err) => {
        if (err.error) {
          try {
            const res = JSON.parse(err.error);
            this.errorMessage = res.message;
          } catch {
            this.errorMessage = `Error with status: ${err.status} - ${err.statusText}`;
          }
        } else {
          this.errorMessage = `Error with status: ${err.status}`;
        }
      },
    });
  }
}
