export const useSpaceShips = () => {
  const fetchSpaceships = async () => {
    const response = await fetch('/ships');

    // eslint-disable-next-line no-console
    console.log(response);
    const data = await response.json();

    return data as { name: string }[];
  };

  return { fetchSpaceships };
};
