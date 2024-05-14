import Reward from "../../components/layout/Rewards";
import {useQuery, isError} from "react-query";
import {FC} from "react";

interface Reward {
    id: number;
    description: string;
    name: string;
    pricePoints: number;
    image: string;
  }

  export let rewardsData: Reward[] = [];
const SectionRewards:FC = () => {

    const { isLoading, error, data } = useQuery("rewards", () =>
        fetch("http://localhost:8080/rewards").then((response) =>
          response.json()
        )
      );
    
      if (isLoading) return <div>Cargando...</div>;
    
      if (error) return isError(error) ? <div>Error: {error.message}</div> : <div>Error: Algo salió mal</div>;
 
      rewardsData = data;

    const rewardsGroups: Reward[][] = [];
    for (let i = 0; i < data.length; i += 3) {
        rewardsGroups.push(data.slice(i, i + 3));
    }
  return (
    <div className="container" style={{marginTop: "50px"}}>
      <div>fdgds</div>
            <div className="row center">
                {rewardsGroups.map((group: Reward[], groupIndex: number) => (
                    <div key={groupIndex} className="row center">
                        {group.map((reward: Reward, index: number) => (
                            <Reward
                                key={index}
                                id={reward.id}
                                titulo={reward.name}
                                mensaje={reward.description}
                                precio={reward.pricePoints}
                                imagen={reward.image}
                            />
                        ))}
                    </div>
                ))}
            </div>
        </div>
  )
}

export default SectionRewards