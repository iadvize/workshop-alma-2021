import * as t from 'io-ts';

export const messageDecoder = t.type({
  text: t.string,
  id: t.string,
  isMine: t.boolean,
});

// eslint-disable-next-line no-warning-comments
// TODO: please implement a shipMessageDecoder
