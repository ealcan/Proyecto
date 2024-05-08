import Nav from '../../components/layout/Nav';
import Reward from "../../components/layout/Rewards";
import Paisaje from '../../assets/Paisaje.jpg'
import {useQuery, isError} from "react-query";
import {FC} from "react";
  
  
  interface Reward {
    description: string;
    name: string;
    pricePoints: number;
  }
  
  
const rewards: FC = () => {
    const { isLoading, error, data } = useQuery("rewards", () =>
        fetch("http://localhost:8080/rewards").then((response) =>
          response.json()
        )
      );
    
      if (isLoading) return <div>Cargando...</div>;
    
      if (error) return isError(error) ? <div>Error: {error.message}</div> : <div>Error: Algo salió mal</div>;
 

    const rewardsGroups: Reward[][] = [];
    for (let i = 0; i < data.length; i += 3) {
        rewardsGroups.push(data.slice(i, i + 3));
    }

      return (
    
    <>
    <header>
        <Nav />
    </header>
    <body >
    <div className="container">
            <br /><br />
            <h3 className="header col s12 light deep-orange-text text-lighten-2 letraGrosor center">Recompensas</h3>
            <br /><br />
            <div className="row center">
                {rewardsGroups.map((group: Reward[], groupIndex: number) => (
                    <div key={groupIndex} className="row center">
                        {group.map((reward: Reward, index: number) => (
                            <Reward
                                key={index}
                                titulo={reward.name}
                                mensaje={reward.description}
                                precio={reward.pricePoints}
                                imagen={Paisaje}
                            />
                        ))}
                    </div>
                ))}
            </div>
        </div>
    </body>
    
    </>
  )
}

export default rewards