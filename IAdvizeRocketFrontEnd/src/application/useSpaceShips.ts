import { pipe } from 'fp-ts/function';
import * as Either from 'fp-ts/Either';
import { shipsDecoder } from '../domain/Ships/Ships.decoder';
import { formatShips } from '../domain/Ships/Ships.adpater.input';
import { Ship } from '../domain/Ships/Ships.entity';

export const useSpaceShips = () => {
  const fetchSpaceships = async () => {
    const response = await fetch('http://localhost:9000/ships');

    const data = await response.json();

    return pipe(
      data,
      shipsDecoder.decode,
      Either.map(formatShips),
      Either.getOrElse<unknown, Ship[]>(() => []),
    );
  };

  return { fetchSpaceships };
};
