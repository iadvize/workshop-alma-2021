import { useCallback, useEffect } from 'react';
import { Message } from '../domain/Message/Message.entity';
import { useSpaceShips } from './useSpaceShips';

const useBot = (
  messages: Message[],
  addMessage: (text: string, isMine: boolean) => void,
) => {
  const { fetchSpaceships } = useSpaceShips();

  const sendMessageWithDelay = useCallback(
    (message: string, delay = 800) => {
      setTimeout(() => {
        addMessage(message, false);
      }, delay);
    },
    [addMessage],
  );

  useEffect(() => {
    const lastMessage = messages[messages.length - 1];

    if (lastMessage.isMine && lastMessage.text === 'answer me') {
      sendMessageWithDelay('ok here I am');
    }

    if (lastMessage.isMine && lastMessage.text === 'help') {
      sendMessageWithDelay("I can't do a lot yet :/");
    }

    if (lastMessage.isMine && lastMessage.text === 'ships') {
      sendMessageWithDelay('I will fetch some for you 🚀');

      fetchSpaceships().then((ships) => {
        ships.slice(0, 3).forEach((ship) => {
          sendMessageWithDelay(`Here is ${ship.name}`);
        });
      });
    }
  }, [fetchSpaceships, messages, sendMessageWithDelay]);
};

export default useBot;
