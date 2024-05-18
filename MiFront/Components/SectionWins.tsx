import { useMediaQuery } from 'react-responsive'; // Importa useMediaQuery de react-responsive
import { useQuery, isError } from 'react-query';
import { FC, useEffect, useState } from 'react';
import Wins from '../../components/layout/Wins';
import '../../styles/WinsStyle.css';
import WinsMediaQuery from "../layout/WinsMediaQuery"

interface WinsData {
  id: number;
  name: string;
  description: string;
  rewardsPoints: number;
  difficulty: string;
  image: string;
}

const SectionWins: FC = () => {
  const { isLoading, error, data } = useQuery<WinsData[]>('wins', () =>
    fetch('http://localhost:8080/wins').then((response) => response.json())
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
  if (!data) return null;

  return (
    <div className="container">
      {/* Contenido antes del carousel */}
      <div style={{ marginBottom: '-140px', height: '150px' }}></div>
      <div style={{ marginBottom: '-130px', height: '150px' }}></div>
      <div style={{ marginBottom: '-100px' }}>
        <h2 className="letraWins2 row center">DISPONIBLES</h2>
        <h4 className="letraWins2 row center">Comienza uno de los retos disponibles y obtén los puntos una vez lo verifiques</h4>
      </div>

      {/* Mostrar el carousel si la pantalla es lo suficientemente grande */}
      {!isSmallScreen && (
        <div className="carousel" style={{ height: '800px', marginLeft: '-65px' }}>
          {data.map((win: WinsData, index: number) => (
            <a key={index} className="carousel-item" href={`#${index}`} style={{ height: '500px' }}>
              <div style={{ margin: '-10px' }}>
                <Wins
                  id={win.id}
                  name={win.name}
                  description={win.description}
                  rewardsPoints={win.rewardsPoints}
                  difficulty={win.difficulty}
                  image={win.image}
                />
              </div>
            </a>
          ))}
        </div>
      )}

      {/* Mostrar el componente CompletedWins si la pantalla es lo suficientemente pequeña */}
      {isSmallScreen && <WinsMediaQuery />}
    </div>
  );
}

export default SectionWins;
