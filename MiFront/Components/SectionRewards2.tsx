import { FC, useEffect, useState } from "react";
import { useQuery, isError } from "react-query";
import "../../styles/WinsStyle.css"

interface Reward {
    id: number;
    description: string;
    name: string;
    pricePoints: number;
    image: string;
  }

const username = "user2";

const SectionRewards2: FC = () => {
    
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

  const { isLoading, error, data } = useQuery<Reward[]>("completedRewards", async () => {
    if (!idUser) return [];
    const response = await fetch(`http://localhost:8080/users/${idUser}/rewards`);
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
    
    <div className="container" style={{width:"100%"}}>
    <ul className="collection borderBottomLeft borderBottomRight">
      {data?.map((rewards: Reward, index: number) => (
        <li key={index} className="collection-item avatar">
          <img src={rewards.image} alt="" className="circle" />
          <span className="title left">{rewards.name}</span>
          <i className="secondary-content material-icons">check</i>
        </li>
      ))}
    </ul>
    </div>
  );
}

export default SectionRewards2;