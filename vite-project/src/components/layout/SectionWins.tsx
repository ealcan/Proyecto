import {useQuery, isError} from "react-query";
import {FC, useState} from "react";
import Wins from "../../components/layout/Wins";

interface Wins {
    name: string;
    description: string;
    rewardsPoints: number;
    difficulty: string;
  }
const SectionWins:FC = () => {

    const { isLoading, error, data } = useQuery("wins", () =>
        fetch("http://localhost:8080/wins").then((response) =>
          response.json()
        )
      );

      const [currentIndex, setCurrentIndex] = useState(0);

    const handleNext = () => {
        setCurrentIndex((prevIndex) => prevIndex + 1);
    };

    const handlePrevious = () => {
        setCurrentIndex((prevIndex) => prevIndex - 1);
    };
    
    
      if (isLoading) return <div>Cargando...</div>;
    
      if (error) return isError(error) ? <div>Error: {error.message}</div> : <div>Error: Algo salió mal</div>;
 

    const winsGroups: Wins[][] = [];
    for (let i = 0; i < data.length; i += 1) {
      winsGroups.push(data.slice(i, i + 3));
    }

    

    const currentGroup = data.slice(currentIndex, currentIndex + 3);
   
    
  return (
    
    <div className="container" style={{marginTop: "50px"}}>

            <div className="row center" >

                {currentGroup.map((win: Wins, index: number) => (
                    <div key={index} style={{ margin: "-10px" }}>
                        <Wins
                            name={win.name}
                            description={win.description}
                            rewardsPoints={win.rewardsPoints}
                            difficulty={win.difficulty}
                        />
                    </div>
                ))}
                
            </div>

            <div className="row center">
                <button onClick={handlePrevious} disabled={currentIndex === 0} className= "btn-large #263238 blue-grey darken-4" style={{ marginRight: "2px" }}><i className="material-icons">navigate_before</i></button>
                <button onClick={handleNext} disabled={currentIndex + 1 >= data.length} className= "btn-large #263238 blue-grey darken-4" style={{ marginLeft: "2px" }}>  <i className="material-icons">navigate_next</i></button>
            </div> 
            </div> 
        
  )
}

export default SectionWins