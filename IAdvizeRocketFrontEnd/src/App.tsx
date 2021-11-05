import React from 'react';
import styles from './App.module.scss';
import iadvizeLogo from './iadvize-logo.png';
import useMessages from './application/useMessages';
import useBot from './application/useBot';
import ComposeBox from './components/ComposeBox/ComposeBox';
import { messageDecoder } from './domain/Message/Message.api';
import TextMessage from './components/TextMessage/TextMessage';

function App() {
  const {
    messages,
    addMessage,
    messageListRef,
    scrollToBottom,
    isSeeLastMessageDisplayed,
  } = useMessages();

  useBot(messages, addMessage);

  return (
    <div className={styles.app}>
      <header className={styles.title}>
        <img src={iadvizeLogo} alt="iAdvize logo" className={styles.logo} />
        <h1>((( Space bot )))</h1>
      </header>
      <div className={styles.messageListWrapper}>
        {isSeeLastMessageDisplayed && (
          <button
            className={styles.seeLastMessages}
            onClick={scrollToBottom}
            type="button"
          >
            Voir les derniers messages
          </button>
        )}
        <div className={styles.messageList} ref={messageListRef}>
          {messages.map((message) => {
            if (messageDecoder.is(message)) {
              return <TextMessage message={message} />;
            }
            return <div>Unknown message type</div>;
          })}
        </div>
      </div>
      <ComposeBox addMessage={addMessage} scrollToBottom={scrollToBottom} />
    </div>
  );
}

export default App;
