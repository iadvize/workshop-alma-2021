import { Ship } from '../Ships/Ships.entity';

export type Message = TextMessage | ShipMessage;

export type TextMessage = {
  text: string;
  isMine: boolean;
  id: string;
};

export type ShipMessage = {
  isMine: false;
  id: string;
  ship: Ship;
};
