import React, { useCallback, useState } from 'react';
import styles from './ComposeBox.module.scss';

type Props = {
  addMessage: (message: { text: string; isMine: boolean }) => void;
  scrollToBottom: () => void;
};

const ComposeBox = ({ addMessage, scrollToBottom }: Props) => {
  const [composeBoxText, setComposeBoxText] = useState('');

  const onAddMessage = useCallback(
    (e: React.KeyboardEvent<HTMLTextAreaElement>) => {
      if (e.key === 'Enter' && composeBoxText.trim() !== '') {
        addMessage({ text: composeBoxText, isMine: true });
        e.preventDefault();
        setComposeBoxText('');
        scrollToBottom();
      }
    },
    [addMessage, composeBoxText, scrollToBottom],
  );

  return (
    <div className={styles.composeBox}>
      <textarea
        placeholder="Enter a message"
        onChange={(e) => setComposeBoxText(e.target.value)}
        onKeyDown={onAddMessage}
        value={composeBoxText}
      />
    </div>
  );
};

export default ComposeBox;
