import * as t from 'io-ts';

export const shipDecoder = t.type({
  id: t.string,
  name: t.string,
  from: t.union([t.literal('swapi'), t.literal('spaceX')]),
});

export const shipsDecoder = t.array(shipDecoder);

export type ShipsDecoder = t.TypeOf<typeof shipsDecoder>;
