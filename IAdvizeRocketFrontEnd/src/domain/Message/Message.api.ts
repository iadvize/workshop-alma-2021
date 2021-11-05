import * as t from 'io-ts';

export const messageDecoder = t.type({
  text: t.string,
  id: t.string,
  isMine: t.boolean,
});

// TODO: please implement a shipMessageDecoder
