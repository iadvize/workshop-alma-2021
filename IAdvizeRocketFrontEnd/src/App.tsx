import React from 'react';
import classnames from 'classnames';
import styles from './App.module.scss';
import iadvizeLogo from './iadvize-logo.png';
import useMessages from './application/useMessages';
import useBot from './application/useBot';
import ComposeBox from './components/ComposeBox/ComposeBox';

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
          {messages.map(({ isMine, id, text }) => (
            <div
              className={classnames(
                styles.message,
                { [styles.mine]: isMine },
                { [styles.other]: !isMine },
              )}
              id={id}
            >
              {text}
            </div>
          ))}
        </div>
      </div>
      <ComposeBox addMessage={addMessage} scrollToBottom={scrollToBottom} />
    </div>
  );
}

export default App;
