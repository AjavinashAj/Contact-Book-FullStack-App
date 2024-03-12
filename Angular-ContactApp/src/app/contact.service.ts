import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Contact } from './contact';

@Injectable({
  providedIn: 'root'
})
export class ContactService {


  private baseUrl='http://localhost:9090/contacts';

  constructor(private httpClient: HttpClient) { }

  getAllContacts():Observable<Contact[]>{
    return this.httpClient.get<Contact[]>(`${this.baseUrl}/getAll`);
  }
  createContact(contact:Contact):Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}/save`,contact,{responseType:"text"});
  }
  removeContact(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseUrl}/delete/${id}`,{responseType:"text"})
  }
  findContact(id:number):Observable<Contact>{
    return this.httpClient.get<Contact>(`${this.baseUrl}/${id}`)
  }

  updateContact(contact:Contact):Observable<Object>{
    return this.httpClient.put(`${this.baseUrl}/update`,contact,{responseType:"text"});
  }
}
