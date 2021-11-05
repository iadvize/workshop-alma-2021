import { useCallback, useEffect } from 'react';
import { Message } from '../domain/Message/Message.entity';
import { useSpaceShips } from './useSpaceShips';
import { Ship } from '../domain/Ships/Ships.entity';

const useBot = (
  messages: Message[],
  addMessage: (message: { text: string; isMine: boolean } | Ship) => void,
) => {
  const { fetchSpaceships } = useSpaceShips();

  const sendMessageWithDelay = useCallback(
    (message: string | Ship, delay = 800) =>
      new Promise((resolve) => {
        setTimeout(() => {
          if (typeof message === 'string') {
            addMessage({ text: message, isMine: false });
          } else {
            addMessage(message);
          }
          resolve(true);
        }, delay);
      }),
    [addMessage],
  );

  useEffect(() => {
    const lastMessage = messages[messages.length - 1];

    if (lastMessage.isMine && lastMessage.text === 'help') {
      sendMessageWithDelay(
        "I can fetch some space ships if you send `ships`. But I can't display markdown *correctly* 😭",
      );
    }

    if (lastMessage.isMine && lastMessage.text === 'ships') {
      sendMessageWithDelay('I will fetch some for you 🚀');

      fetchSpaceships().then(async (ships) => {
        // eslint-disable-next-line no-restricted-syntax
        for (const ship of ships.slice(0, 5)) {
          // eslint-disable-next-line no-await-in-loop
          await sendMessageWithDelay(ship, 1000);
        }
      });
    }
  }, [fetchSpaceships, messages, sendMessageWithDelay]);
};

export default useBot;
