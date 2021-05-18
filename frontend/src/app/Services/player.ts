import { League } from "../league";

export interface Player {
    id: number;
    name: string;
    wins: number;
    losses: number;
    draws: number;
    goals: number;
    leagues: League[];
}