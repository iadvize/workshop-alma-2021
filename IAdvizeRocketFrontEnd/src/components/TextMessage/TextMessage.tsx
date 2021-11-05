import classnames from 'classnames';
import React from 'react';
import styles from './TextMessage.module.scss';
import { TextMessage as TextMessageEntity } from '../../domain/Message/Message.entity';

type Props = {
  message: TextMessageEntity;
};

const TextMessage = ({ message }: Props) => (
  <div
    className={classnames(
      styles.message,
      { [styles.mine]: message.isMine },
      { [styles.other]: !message.isMine },
    )}
    id={message.id}
    key={message.id}
  >
    {message.text}
  </div>
);

export default TextMessage;
