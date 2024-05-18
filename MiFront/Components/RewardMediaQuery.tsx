import Rewards2 from "../layout/Rewards2"
import {useQuery, isError} from "react-query";
import {FC, useEffect, useState} from "react";
import Fondo from "../../assets/Grises.jpg"

interface Reward2 {
    id: number;
    description: string;
    name: string;
    pricePoints: number;
    image: string;
  }

  export let rewardsData: Reward2[] = [];
const SectionRewards:FC = () => {

    const { isLoading, error, data } = useQuery("rewards", () =>
        fetch("http://localhost:8080/rewards").then((response) =>
          response.json()
        )
      );
      const [carouselInitialized, setCarouselInitialized] = useState(false);

  useEffect(() => {
    const initializeCarousel = () => {
      const elems = document.querySelectorAll('.carousel');
      M.Carousel.init(elems, {});
      setCarouselInitialized(true);
    };

    if (!carouselInitialized) {
      initializeCarousel();
    }
  }, [carouselInitialized]);

  useEffect(() => {
    const initializeCarousel = () => {
      const elems = document.querySelectorAll('.carousel');
      M.Carousel.init(elems, {});
    };
  
    if (!isLoading && !error && data) {
      if (carouselInitialized) {
        initializeCarousel();
      }
    }
  }, [isLoading, error, data, carouselInitialized]);
    
      if (isLoading) return <div>Cargando...</div>;
    
      if (error) return isError(error) ? <div>Error: {error.message}</div> : <div>Error: Algo salió mal</div>;
 
      rewardsData = data;

    const rewardsGroups: Reward2[][] = [];
    for (let i = 0; i < data.length; i += 1) {
        rewardsGroups.push(data.slice(i, i + 1));
    }
  return (
    <div className="container">
        <div style={{ marginBottom: "-140px", height: "150px" }}></div>
      <div style={{ marginBottom: "-130px", height: "150px" }}></div>
      
            <div className="row center" >
                {rewardsGroups.map((group: Reward2[], groupIndex: number) => (
                    <div key={groupIndex} className="row center" style={{marginTop: "-20px"}}>
                        {group.map((reward: Reward2, index: number) => (
                            <Rewards2
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