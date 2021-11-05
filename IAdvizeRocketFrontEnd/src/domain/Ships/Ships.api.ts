import * as t from 'io-ts';

export const shipEntityDecoder = t.type({
  id: t.string,
  name: t.string,
  source: t.union([t.literal('Star wars'), t.literal('spaceX')]),
});
