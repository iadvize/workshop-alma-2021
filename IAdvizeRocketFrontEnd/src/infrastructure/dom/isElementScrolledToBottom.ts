export const isElementScrolledToBottom = (element: HTMLElement) =>
  element.scrollTop - (element.scrollHeight - element.offsetHeight) === 0;
