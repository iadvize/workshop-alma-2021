import { useEffect } from 'react';
import { Message } from '../domain/Message/Message.entity';

const useBot = (
  messages: Message[],
  addMessage: (text: string, isMine: boolean) => void,
) => {
  useEffect(() => {
    const lastMessage = messages[messages.length - 1];

    if (lastMessage.isMine && lastMessage.text === 'answer me') {
      setTimeout(() => {
        addMessage('ok here I am', false);
      }, 800);
    }

    if (lastMessage.isMine && lastMessage.text === 'help') {
      setTimeout(() => {
        addMessage("I can't do a lot yet :/", false);
      }, 800);
    }
  }, [addMessage, messages]);
};

export default useBot;
