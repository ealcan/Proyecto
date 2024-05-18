import Reward from "../../components/layout/Rewards";
import {useQuery, isError} from "react-query";
import {FC, useEffect, useState} from "react";
import { useMediaQuery } from 'react-responsive';
import RewardMediaQuery from "../layout/RewardMediaQuery";
import "../../styles/WinsStyle.css"


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

  const isSmallScreen = useMediaQuery({ maxWidth: 600 });   
      if (isLoading) return <div>Cargando...</div>;
    
      if (error) return isError(error) ? <div>Error: {error.message}</div> : <div>Error: Algo salió mal</div>;
 
  
  return (
    
    <div className="container">
      <div style={{marginBottom:"-140px", height: "150px"}}></div>
      <div style={{marginBottom:"-130px", height: "150px"}}></div>
      <div style={{marginBottom: "-100px"}}>
        <h2 className="letraWins2 row center  ">DISPONIBLES</h2>
        <h4 className="letraWins2 row center">¡Caneja aquí tus puntos por fantásticos premios!</h4>
      </div>
        
      {!isSmallScreen  && (
      <div className="carousel" style={{ height: "800px", marginLeft: "-65px"}}>
        {data.map((rewards: Reward, index: number) => (
          <a key={index} className="carousel-item" href={`#${index}`} style={{ height: "500px" }}>
            <div style={{ margin: "-10px" }}>
              <Reward
                id={rewards.id}
                mensaje={rewards.description}
                titulo={rewards.name}
                precio={rewards.pricePoints}
                imagen={rewards.image}
              />
            </div>
          </a>
        ))}
      </div>
       )}
       {(isSmallScreen ) && <RewardMediaQuery />}
    </div>
  )
}

export default SectionRewards