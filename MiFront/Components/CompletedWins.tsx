import { FC, useEffect, useState } from "react";
import { useQuery, isError } from "react-query";
import "../../styles/WinsStyle.css"

interface Wins {
  id: number;
  name: string;
  description: string;
  rewardsPoints: number;
  difficulty: string;
  image: string;
}

const username = "user2";

const CompletedWins: FC = () => {
    
  const [idUser, setIdUser] = useState<number | null>(null);
  const [isLoadingUser, setIsLoadingUser] = useState<boolean>(false);

  useEffect(() => {
    const fetchUserData = async () => {
      setIsLoadingUser(true);
      try {
        const response = await fetch(`http://localhost:8080/users/find/${username}`);
        if (!response.ok) {
          throw new Error('Failed to fetch user data');
        }
        const userData = await response.json();
        setIdUser(userData.id);
      } catch (error) {
        console.error('Error fetching user data:', error);
      } finally {
        setIsLoadingUser(false);
      }
    };

    fetchUserData();
  }, []);

  const { isLoading, error, data } = useQuery<Wins[]>("completedWins", async () => {
    if (!idUser) return [];
    const response = await fetch(`http://localhost:8080/users/${idUser}/verified-wins`);
    if (!response.ok) {
      throw new Error('Failed to fetch wins data');
    }
    return response.json();
  }, {
    enabled: !!idUser // Solo habilita la consulta cuando idUser no sea nulo
  });

  if (isLoadingUser) return <div>Cargando usuario...</div>;

  if (isLoading) return <div>Cargando...</div>;

  if (error) return isError(error) ? <div>Error: {error.message}</div> : <div>Error: Algo salió mal</div>;

  return (
    <ul className="collection borderBottomLeft">
      {data?.map((win: Wins, index: number) => (
        <li key={index} className="collection-item avatar">
          <img src={win.image} alt="" className="circle" />
          <span className="title">{win.name}</span>
          <p>{win.description}</p>
          <i className="secondary-content material-icons">check</i>
        </li>
      ))}
    </ul>
  );
}

export default CompletedWins;
