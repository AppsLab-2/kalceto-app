import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { MyLeagueService } from '../Services/myleague.service';
import { Observable} from 'rxjs';
import { Matches } from '../matches';
import { Player } from '../player';
import { PlayerScore } from '../playerscore';

const PLAYER_DATA: PlayerScore[] = [
  {position: 1, name: 'Player1', wins: 10, loses: 0, draws:0, points:30},
  {position: 2, name: 'Player2', wins: 4, loses: 6, draws:1, points:13},
  {position: 3, name: 'Player3', wins: 9, loses: 1, draws:2, points:29},
  {position: 4, name: 'Player4', wins: 6, loses: 4, draws:3, points:21},
  {position: 5, name: 'Player5', wins: 5, loses: 5, draws:4, points:19},
  {position: 6, name: 'Player6', wins: 7, loses: 3, draws:5, points:26},
  {position: 7, name: 'Player7', wins: 3, loses: 7, draws:6, points:15},
  {position: 8, name: 'Player8', wins: 1, loses: 9, draws:7, points:10},
  {position: 9, name: 'Player9', wins: 2, loses: 8, draws:8, points:14},
  {position: 10, name: 'Player10', wins: 0, loses: 10, draws:9, points:9},
];

@Component({
  selector: 'app-my-league',
  templateUrl: './my-league.component.html',
  styleUrls: ['./my-league.component.css']
})
export class MyLeagueComponent implements OnInit {
  matches = Array.from({length: 100}).map((_, i)=> `Match #${i}`); 

  displayColumns: string[] = ['position' , 'name' , 'wins' , 'loses' , 'draws' , 'points'];
  dataSource = new MatTableDataSource<PlayerScore>(PLAYER_DATA);

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  @ViewChild(MatSort)
  sort!: MatSort;

  constructor(private myleagueservice: MyLeagueService) { }

  player?: Observable <Player>;
  selectedPlayer!: Player;
  match?: Observable <Matches>;

  

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.match = this.myleagueservice.getMatchesfromLeague();
  }
  onSelect(player: Player): void {
    this.selectedPlayer = player;
  }
}
