import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Match } from './league';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const leagues = [
      { id: 1, name: 'League name', },
      { id: 2, name: 'League name',},
      { id: 3, name: 'League name', },
      { id: 4, name: 'League name', },
      { id: 5, name: 'League name', },
      { id: 6, name: 'League name', },
      { id: 7, name: 'League name', },
      { id: 8, name: 'League name', },
      { id: 9, name: 'League name', },
      { id: 10, name: 'League name', },
      { id: 11, name: 'League name', },
      { id: 12, name: 'League name', },
      { id: 13, name: 'League name', },
      { id: 14, name: 'League name', },
      { id: 15, name: 'League name', },
      { id: 16, name: 'League name', }    
    ];
    return {leagues};
  }

  genId(leagues: Match[]): number {
    return leagues.length > 0 ? Math.max(...leagues.map(match => match.id)) + 1 : 11;
  }
  

  constructor() { }
}
