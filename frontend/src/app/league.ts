import { Player } from "./player";

export interface League {
    id: number;
    leagueName: string;
    players: Player[];
}