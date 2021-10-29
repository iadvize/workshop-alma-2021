import { useCallback, useLayoutEffect, useRef, useState } from 'react';
import { v4 as uuid } from 'uuid';
import { useScrolling } from 'react-use';
import { Message } from '../domain/Message/Message.entity';
import { isElementScrolledToBottom } from '../infrastructure/dom/isElementScrolledToBottom';

const useMessages = () => {
  const messageListRef = useRef<HTMLDivElement>(null);

  const [messages, setMessages] = useState<Message[]>([
    {
      text: "Hello, I'm a bot, type `help` to know what I can do",
      isMine: false,
      id: uuid(),
    },
    { text: 'How do you do ?', isMine: false, id: uuid() },
  ]);

  const [isSeeLastMessageDisplayed, setIsSeeLastMessageDisplayed] =
    useState(false);

  const scrollToBottom = useCallback(() => {
    setTimeout(() => {
      if (messageListRef.current) {
        messageListRef.current.scrollTo({
          top: messageListRef.current.scrollHeight,
          left: 0,
          behavior: 'smooth',
        });
      }
    }, 0);
  }, []);

  const addMessage = useCallback(
    (message: string, isMine: boolean) => {
      if (messageListRef.current) {
        const isScrolledToBottom = isElementScrolledToBottom(
          messageListRef.current,
        );

        setMessages((messages) => [
          ...messages,
          {
            text: message,
            isMine,
            id: uuid(),
          },
        ]);

        if (isScrolledToBottom) {
          scrollToBottom();
        }
      }
    },
    [scrollToBottom],
  );
  const isScrolling = useScrolling(messageListRef);

  useLayoutEffect(() => {
    setTimeout(() => {
      setIsSeeLastMessageDisplayed(
        messageListRef.current
          ? !isElementScrolledToBottom(messageListRef.current)
          : false,
      );
    }, 300);
  }, [isScrolling]);
  return {
    messages,
    addMessage,
    isElementScrolledToBottom,
    messageListRef,
    isSeeLastMessageDisplayed,
    scrollToBottom,
  };
};

export default useMessages;
