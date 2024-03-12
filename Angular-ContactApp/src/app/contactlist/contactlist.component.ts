import { Component } from '@angular/core';
import { Contact } from '../contact';
import { ContactService } from '../contact.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contactlist',
  templateUrl: './contactlist.component.html',
  styleUrls: ['./contactlist.component.css']
})
export class ContactlistComponent {

  contacts: Contact[] = [];
  constructor(private contactService: ContactService, private router: Router) {
  }

  ngOnInit(): void {
    this.getAllContacts();
  }

  getAllContacts() {
    this.contactService.getAllContacts().subscribe(
      data => {
        this.contacts = data;
      }
    );
  }
  //remove a contact
  deleteContact(id: number) {
    this.contactService.removeContact(id).subscribe(
      data => {
        console.log("SUCCESSFULL........");
        console.log(data);
        this.getAllContacts();
      },
      error => {
        console.log("FAILED........");
        console.log(error);
      }
    )
  }
  //edit a contact
  editContact(id: number) {
    console.log("Edited :: " + id);
    this.router.navigate(['/edit', id]);
  }

}
