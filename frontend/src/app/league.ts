import { Player } from "./Services/player";

export interface League {
    id: number;
    leagueName: string;
    players: Player[];
}