import { Partido } from "./political";

export class Presidente {
    id: bigint;
    nombre: string;
    edad: bigint;
    puestoRobado: bigint;
    calidadGobierno: bigint;
    esDios: boolean;
    partido: Partido;
}