import { ShipsDecoder } from './Ships.decoder';
import { Ship } from './Ships.entity';

export const formatShips = (ships: ShipsDecoder): Ship[] =>
  ships.map((ship) => ({
    id: ship.id,
    name: ship.name,
    source: ship.from === 'swapi' ? 'spaceX' : 'Star wars',
  }));
